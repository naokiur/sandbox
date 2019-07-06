package jp.ne.naokiur.api

//import UserController
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
import io.ktor.routing.get
import io.ktor.routing.routing
import jp.ne.naokiur.transcribing.classesandobjects.LateInitializedPropertiesAndVariables
import java.text.DateFormat

fun Application.transcribing() {

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
//            val basicSyntax = BasicSyntax()
//            basicSyntax.execute()

//            val idioms = Idioms()
//            idioms.execute()

//            val controlFlow = ControlFlow()
//            controlFlow.execute()

//            val returnsAndJumps = ReturnsAndJumps()
//            returnsAndJumps.execute()

//            val classesAndInheritance = ClassesAndInheritance()
//            classesAndInheritance.execute()

//            val propertiesAndFields = PropertiesAndFields()
//            propertiesAndFields.execute()

//            val compileTimeConstants = CompileTimeConstants()
//            compileTimeConstants.execute()

            val lateInitializedPropertiesAndVariables = LateInitializedPropertiesAndVariables()
            lateInitializedPropertiesAndVariables.execute()

            val gson = GsonBuilder().setPrettyPrinting().create()
            call.respond(gson.toJson("Hello"))
        }
    }
}