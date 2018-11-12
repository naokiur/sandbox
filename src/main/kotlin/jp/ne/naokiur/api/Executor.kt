package jp.ne.naokiur.api

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.receive
import io.ktor.request.receiveMultipart
import io.ktor.request.receiveParameters
import io.ktor.response.*
import io.ktor.routing.*
import java.text.*
import java.time.*
import jp.ne.naokiur.api.controller.UserController
import java.text.DateFormat
import javax.print.attribute.standard.Compression

fun Application.main() {
    data class Parameter(val message: String)

    val controller = UserController()
//    install(DefaultHeaders)
//    install(Compression)
//    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    routing {
        get("/") {
            call.respondText("Hello, world!", ContentType.Text.Html)
        }
        get("/show") {
//                call.respondText(controller.show(), ContentType.Text.Html)
            call.respond(controller.show())
        }
        post("/create") {
            val parameter = call.receive<String>()
//            val res = call.receiveParameters()
//            println(parameter)
            println(parameter)
//            println(res)
            call.respondText("create!!")

//            println(parameter.message)
        }
    }
}
