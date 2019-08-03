package jp.ne.naokiur.sample.fuel

import com.google.gson.GsonBuilder
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.Compression
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import java.text.DateFormat

fun Application.fuelSampleApi() {

    install(DefaultHeaders)
    install(Compression)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    routing {
        get("/") {
            call.respondText("fuel sample api!")
        }
        get("/text") {
            call.respondText("access Text!")
        }
        get("/json") {
            val gson = GsonBuilder().setPrettyPrinting().create()
            val res = mapOf("message" to "access json!", "a" to "1", "b" to "2")
            call.respond(gson.toJson(res))
        }
    }
}