package jp.ne.naokiur.api.controller

import jp.ne.naokiur.user.domain.applications.UserApplicationService

class UserController {
    val service = UserApplicationService()

    fun show(): String {
        val users = service.showUsers()

        var result = ""

        for (user in users) {
            result += "${user.userId.id} ${user.fullName.name}\n"
        }

        return result
    }
}