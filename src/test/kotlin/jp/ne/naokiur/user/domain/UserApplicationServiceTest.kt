package jp.ne.naokiur.user.domain

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.infra.InMemoryUserRepository
import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserName
import jp.ne.naokiur.user.domain.models.users.UserService
import java.lang.Exception
import kotlin.test.Test
import kotlin.test.assertEquals

class UserApplicationServiceTest {
    private val repository = InMemoryUserRepository()
    private val service = UserService(repository)
    private val applicationService = UserApplicationService(service, repository)

    @Test
    fun testCreateUser() {
        val targetUserName = "created"

        applicationService.createUser(targetUserName, "createdFirst", "createdFamily")

        val result = repository.find(UserName(targetUserName))
        assertEquals(result?.userName?.name, targetUserName)
    }

    @Test(expected = Exception::class)
    fun testCreateUser_duplicate() {
        repository.save(User(UserName("created"), FullName("createdFirst", "createdFamily")))

        applicationService.createUser("created", "createdFirst", "createdFamily")
    }

    @Test
    fun testShowUser() {

    }

    @Test
    fun testShowUsers() {
    }

    @Test
    fun testChangeUserInfo() {
        val testUser = User(UserName("changed"), FullName("changedFirst", "changedLast"))
        applicationService.changeUserInfo(testUser)

        val resultUser = applicationService.showUser(testUser.userName)
        assertEquals(testUser.fullName.name, resultUser?.fullName?.name)
    }
}