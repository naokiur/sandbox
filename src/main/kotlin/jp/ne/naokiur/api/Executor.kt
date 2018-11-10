package jp.ne.naokiur.api

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import jp.ne.naokiur.api.controller.UserController

fun main(args: Array<String>) {
    val controller = UserController()

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Html)
            }
            get("/show") {
                call.respondText(controller.show(), ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}
