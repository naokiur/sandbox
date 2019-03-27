package jp.ne.naokiur.api

import com.google.gson.GsonBuilder
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.receive
import io.ktor.request.receiveParameters
import io.ktor.request.receiveText
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import jp.ne.naokiur.api.controller.UserController
//import jp.ne.naokiur.api.controller.UserController
import jp.ne.naokiur.api.domain.ApiRes
import jp.ne.naokiur.domain.applications.UserApplicationService
import jp.ne.naokiur.domain.infra.EmployeeRepository
import jp.ne.naokiur.domain.infra.UserRepository
import jp.ne.naokiur.domain.models.users.User
import jp.ne.naokiur.domain.models.users.UserFactory
import jp.ne.naokiur.domain.models.users.UserService
import java.text.DateFormat

fun Application.api() {
//    val repository = UserRepository()
//    val service = UserService(repository)
//    val applicationService = UserApplicationService(service, repository)

    val repository = UserRepository()
    val controller = UserController(
            UserApplicationService(UserService(repository), repository, UserFactory())
    )

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
            print("aaaa")
            call.respondText("Hello, world!", ContentType.Text.Html)
        }
        get("/show") {
            call.respond(controller.index())
        }
        get("/create-tables") {
            val empRepository = EmployeeRepository()
            val res = empRepository.createTable()
            call.respondText(res.toString())
        }
        post("/create") {
            val parameter = call.receive<User>()
//            controller.create(parameter)

            // Why does this respond need toJson ? How about `ContentNegotiation` ?
            // if not calling toJson, it will respond `406 Not Acceptable`
            val gson = GsonBuilder().setPrettyPrinting().create()
            call.respond(gson.toJson(ApiRes("Success")))
        }
    }
}
