package jp.ne.naokiur.api.controller

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserService

class UserController(private val service: UserApplicationService) {
//    private val service = UserApplicationService(UserService(UserRepository()), UserRepository())

//    fun show(): List<User> {
//        return service.showUsers()
//    }

    fun create(user: User) {
        service.createUser(user)
    }
}