import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ptr
import platform.darwin.OS_LOG_DEFAULT
import platform.darwin.OS_LOG_TYPE_DEBUG
import platform.darwin.OS_LOG_TYPE_DEFAULT
import platform.darwin.OS_LOG_TYPE_ERROR
import platform.darwin.OS_LOG_TYPE_FAULT
import platform.darwin.OS_LOG_TYPE_INFO
import platform.darwin.__dso_handle
import platform.darwin._os_log_internal

@OptIn(ExperimentalForeignApi::class)
actual fun log(tag: String, message: String, logLevel: LogLevels) {
    val formatedLogLevel = logLevel.setup.emoji + " " + logLevel.name.uppercase().take(1) + " " + logLevel.setup.emoji
    val formatedTag = getFormatedTag(tag)
    _os_log_internal(
        __dso_handle.ptr,
        OS_LOG_DEFAULT,
        logLevel.toDarwin(),
        "$formatedTag $formatedLogLevel $message"
    )
}

private fun LogLevels.toDarwin(): UByte = when (this) {
    LogLevels.Verbose -> OS_LOG_TYPE_DEBUG
    LogLevels.Debug -> OS_LOG_TYPE_INFO
    LogLevels.Info -> OS_LOG_TYPE_DEFAULT
    LogLevels.Warning -> OS_LOG_TYPE_ERROR
    LogLevels.Error -> OS_LOG_TYPE_FAULT
    LogLevels.Assert -> OS_LOG_TYPE_FAULT
}