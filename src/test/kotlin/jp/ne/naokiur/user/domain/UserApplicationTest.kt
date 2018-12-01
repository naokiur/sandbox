package jp.ne.naokiur.user.domain

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName
import kotlin.test.Test
import kotlin.test.assertEquals

class UserApplicationTest {
    private val applicationService = UserApplicationService()

    @Test
    fun testCreateUser() {
        val testUser = User(UserId(3), UserName("created"), FullName("createdFirst", "createdLast"))
        applicationService.createUser(testUser)

        assertEquals(applicationService.showUser(testUser.userId), testUser)
    }

    @Test
    fun testShowUser() {

    }

    @Test
    fun testShowUsers() {
    }

    @Test
    fun testChangeUserInfo() {
        val testUser = User(UserId(2), UserName("changed"), FullName("changedFirst", "changedLast"))
        applicationService.changeUserInfo(testUser)

        val resultUser = applicationService.showUser(testUser.userId)
        assertEquals(testUser.fullName.name, resultUser?.fullName?.name)
    }
}