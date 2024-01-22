package com.naokiur

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.naokiur.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
//        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
