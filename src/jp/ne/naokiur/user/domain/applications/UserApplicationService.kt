package jp.ne.naokiur.user.domain.applications

import jp.ne.naokiur.user.domain.models.users.*


//fun main(args: Array<String>) {
//    showUsers()
//
//    val taroUser = User(userId = UserId(), userName = UserName("taro"), fullName = FullName("Tanaka", "Taro"))
//    createUser(taroUser)
//
//    showUsers()
//}

class UserApplicationService {
    private val service = UserService()

    fun createUser(user: User) {
        if (service.isDuplicated(user)) {
            throw IllegalArgumentException()
        }

        service.register(user)
    }

    fun changeUserInfo(user: User) {

    }

    fun showUsers() {
        service.showUsers()
    }
}