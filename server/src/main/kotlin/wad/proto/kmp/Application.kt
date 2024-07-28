package wad.proto.kmp

import Greeting
import SERVER_PORT
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import log
import mainLibTest

fun main() {
    mainLibTest()
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        get("/") {
            log("Server", "Server Answer")
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}