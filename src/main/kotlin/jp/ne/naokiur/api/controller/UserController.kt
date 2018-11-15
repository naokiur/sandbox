package jp.ne.naokiur.api.controller

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.models.users.User

class UserController {
    private val service = UserApplicationService()

    fun show(): List<User> {
        return service.showUsers()
    }

    fun create(user: User) {
        service.createUser(user)
    }
}