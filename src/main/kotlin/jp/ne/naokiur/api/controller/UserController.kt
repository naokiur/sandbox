package jp.ne.naokiur.api.controller

import jp.ne.naokiur.domain.applications.UserApplicationService
import jp.ne.naokiur.domain.infra.UserRepository
import jp.ne.naokiur.domain.models.users.User
import jp.ne.naokiur.domain.models.users.UserService
import jp.ne.naokiur.domain.models.users.UserSummaryModel

class UserController(private val service: UserApplicationService) {
//    private val service = UserApplicationService(UserService(UserRepository()), UserRepository())
    fun index(): List<UserSummaryModel> {
        return  service.getUserList()
    }
//    fun show(): List<User> {
//        return service.showUsers()
//    }

//    fun create(userName: String , firstName: String, familyName: String) {
//        service.createUser(userName, firstName, familyName)
//    }
}