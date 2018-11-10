package jp.ne.naokiur.api.controller

import jp.ne.naokiur.user.domain.applications.UserApplicationService
import jp.ne.naokiur.user.domain.models.users.User

class UserController {
    private val service = UserApplicationService()

    fun show(): List<User> {
//        val users = service.showUsers()
//
//        var result = ""
//
//        for (user in users) {
//            result += "${user.userId.id} ${user.fullName.name}\n"
//        }

        return service.showUsers()
    }
}