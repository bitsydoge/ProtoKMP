fun main() {
    //language=JSON
    val dummyJson : String = """
        {
          "user": {
            "id": 1,
            "name": "John Doe",
            "email": "john.doe@example.com",
            "isActive": true
          },
          "posts": [
            {
              "id": 101,
              "title": "First Post",
              "content": "This is the content of the first post.",
              "createdAt": "2024-07-26T10:00:00Z"
            },
            {
              "id": 102,
              "title": "Second Post",
              "content": "This is the content of the second post.",
              "createdAt": "2024-07-27T11:00:00Z"
            }
          ],
          "settings": {
            "theme": "dark",
            "notifications": {
              "email": true,
              "sms": false
            }
          }
        }
    """.trimIndent()


    log("Main", Greeting().greet(), LogLevels.Warning)
    log("Core", Greeting().greet(), LogLevels.Error)
    log("MemoryHandler", Greeting().greet(), LogLevels.Info)
    log("Main", Greeting().greet(), LogLevels.Info)
    log("Main", Greeting().greet(), LogLevels.Verbose)
    log("Main", Greeting().greet(), LogLevels.Debug)
    log("Main", "Server Answer :\n$dummyJson", LogLevels.Debug)
    log("Main", Greeting().greet(), LogLevels.Debug)
    log("Main", Greeting().greet(), LogLevels.Verbose)
    log("UserManager", Greeting().greet(), LogLevels.Warning)
    log("Main", Greeting().greet(), LogLevels.Info)
    log("MemoryCleaner", Greeting().greet(), LogLevels.Error)
    log("User", Greeting().greet(), LogLevels.Warning)
}