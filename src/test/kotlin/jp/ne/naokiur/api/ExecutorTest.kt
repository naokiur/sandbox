package jp.ne.naokiur.api

import com.google.gson.GsonBuilder
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import jp.ne.naokiur.user.domain.infra.UserRepository
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
}