package jp.ne.naokiur.api

import com.google.gson.GsonBuilder
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.GsonConverter
import io.ktor.http.*
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import io.ktor.server.testing.withTestApplication
import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName
import kotlin.test.Test
import kotlin.test.assertEquals

class ExecutorTest {
    private val repository = UserRepository()

    @Test
    fun testHello() = withTestApplication(Application::main) {
        handleRequest(HttpMethod.Get, "/").run {
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals("Hello, world!", response.content)
        }
    }

    @Test
    fun testShow() = withTestApplication(Application::main) {
        val gson = GsonBuilder().setPrettyPrinting().create()

        handleRequest(HttpMethod.Get, "/show").run {
            val expectedContent = gson.toJson(repository.findAll())

            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(expectedContent, response.content)
        }
    }

    @Test
    fun testCreate() = withTestApplication(Application::main) {
        val gson = GsonBuilder().setPrettyPrinting().create()

        val expectendUser = User(UserId(3), UserName("test"), FullName("test", "hoge"))

        handleRequest(HttpMethod.Post, "/create") {
            println(ContentType.Application.Json.toString())
            addHeader(HttpHeaders.Accept, ContentType.Text.Plain.toString())
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody("test")

//            setBody(listOf("id" to "3", "userName" to "test", "firstName" to "test", "lastName" to "hoge").formUrlEncode())
        }.run {
            val expectedContent = gson.toJson(repository.findAll())

            assertEquals(HttpStatusCode.OK, response.status())
//            assertEquals(expectedContent, response.content)
        }
    }
}