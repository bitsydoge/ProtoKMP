import AnsiEscapeUtil.BOLD
import AnsiEscapeUtil.colorize
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.absoluteValue

enum class Log {
    Info,
    Warning,
    Error
}

fun getCurrentTimestamp(): Instant {
    return Clock.System.now()
}

expect fun log(tag: String = "Default", message: String, logLevel: Log = Log.Info)

val color = mapOf(
    Log.Info to AnsiEscapeUtil.RESET,
    Log.Warning to AnsiEscapeUtil.YELLOW,
    Log.Error to AnsiEscapeUtil.RED
)
fun formatTimestampForLogging(instant: Instant): String {
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.date} ${localDateTime.time}"
}

val timestamp = getCurrentTimestamp()
val formattedTimestamp = formatTimestampForLogging(timestamp)

val colorPalette = listOf(
    AnsiEscapeUtil.RED,
    AnsiEscapeUtil.GREEN,
    AnsiEscapeUtil.BLUE,
    AnsiEscapeUtil.YELLOW,
    AnsiEscapeUtil.PURPLE,
    AnsiEscapeUtil.CYAN,
    AnsiEscapeUtil.WHITE
)

fun getTrueColorForTag(tag: String): String {
    val hash = tag.hashCode().absoluteValue
    val r = (hash % 256)
    val g = ((hash / 256) % 256)
    val b = ((hash / (256 * 256)) % 256)
    return "\u001B[38;2;$r;$g;$b;m"
}
fun getColorForTag(tag: String): String {
    // Hash the tag and map it to a color palette index
    val index = tag.hashCode().absoluteValue % colorPalette.size
    return colorPalette[index]
}
// Extended list of shape emojis
val emojis = listOf(
    "🟧", "🟨", "🟩", "🟦", "🟪", "🟫", "⬜",
    "🟠", "🟡", "🟢", "🔵", "🟣", "🟤", "⚪",
    "🧡", "💛", "💚", "💙", "💜", "🤎", "🤍"
)

// Function to get a random emoji with an offset based on the current time
fun getRandomEmoji(tag: String): String {
    val hash = tag.hashCode().absoluteValue
    val index = (hash + offset) % emojis.size
    return emojis[index]
}

// Function to get the current time-based offset
val offset = (Clock.System.now().toEpochMilliseconds() / 1000).toInt() % emojis.size

internal fun logPrintln(tag: String = "Default", message: String, logLevel: Log = Log.Info) {
    val formatedLogLevel = colorize(logLevel.name.uppercase().take(7).padEnd(7, ' '), color[logLevel]!!, bold = true)
    val emoji = getRandomEmoji(tag)
    val formatedTag = colorize("$emoji ${tag.take(16).padEnd(16, '.')} $emoji", BOLD, bold = true)
    println("${formattedTimestamp.take(22).padEnd(22)} | $formatedLogLevel | $formatedTag | $message")
}
