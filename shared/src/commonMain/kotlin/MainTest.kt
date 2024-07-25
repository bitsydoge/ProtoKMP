// Everything after this is in red
const val RED = "\u001b[31m"

// Resets previous color codes
const val RESET = "\u001b[0m"

fun main() {
    log("Main", Greeting().greet(), Log.Warning)
    log("Core", Greeting().greet(), Log.Error)
    log("MemoryHandler", Greeting().greet(), Log.Info)
    log("Main", Greeting().greet(), Log.Info)
    log("UserManager", Greeting().greet(), Log.Warning)
    log("Main", Greeting().greet(), Log.Info)
    log("MemoryCleaner", Greeting().greet(), Log.Error)
    log("User", Greeting().greet(), Log.Warning)
}