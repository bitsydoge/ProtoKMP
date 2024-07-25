import AnsiEscapeUtil.colorize

enum class Log {
    Info,
    Warning,
    Error
}

expect fun log(tag: String = "Default", message: String, logLevel: Log = Log.Info)

val color = mapOf(
    Log.Info to AnsiEscapeUtil.RESET,
    Log.Warning to AnsiEscapeUtil.YELLOW,
    Log.Error to AnsiEscapeUtil.RED
)

internal fun logPrintln(tag: String = "Default", message: String, logLevel: Log = Log.Info) {
    val formatedLogLevel = colorize(logLevel.name.uppercase().take(7).padEnd(7, ' '), color[logLevel]!!, bold = true)
    val formatedTag = colorize(tag.take(16).padEnd(16, '.'), AnsiEscapeUtil.WHITE, bold = true)
    println("$formatedLogLevel | $formatedTag | $message")
}
