import android.util.Log
import Log as LogEnum

actual fun log(tag: String, message: String, logLevel: LogEnum) {
    when (logLevel) {
        LogEnum.Info -> Log.i(tag, message)
        LogEnum.Warning -> Log.w(tag, message)
        LogEnum.Error -> Log.e(tag, message)
    }
}