package jp.ne.naokiur.user.domain

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserName
import kotlin.test.Test
import kotlin.test.assertEquals

class UserApplicationTest {
    private val applicationService = UserApplicationService()

    @Test
    fun testCreateUser() {
        val testUser = User(UserName("created"), FullName("createdFirst", "createdLast"))
        applicationService.createUser(testUser)

        assertEquals(applicationService.showUser(testUser.userName), testUser)
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