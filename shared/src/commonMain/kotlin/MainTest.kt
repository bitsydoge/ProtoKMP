// Everything after this is in red
const val RED = "\u001b[31m"

// Resets previous color codes
const val RESET = "\u001b[0m"

fun main() {
    log("Main", Greeting().greet(), Log.Warning)
}