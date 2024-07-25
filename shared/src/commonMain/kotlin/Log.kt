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
    println(colorize(logLevel.name.uppercase(), color[logLevel]!!, underline = true, bold = true) + ": " + message)
}
