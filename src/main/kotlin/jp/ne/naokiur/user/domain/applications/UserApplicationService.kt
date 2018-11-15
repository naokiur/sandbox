package jp.ne.naokiur.user.domain.applications

import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.models.users.*


//fun jp.ne.naokiur.api.main(args: Array<String>) {
//    showUsers()
//
//    val taroUser = User(userId = UserId(), userName = UserName("taro"), fullName = FullName("Tanaka", "Taro"))
//    createUser(taroUser)
//
//    showUsers()
//}

class UserApplicationService {
    private val service = UserService()
    private val repository = UserRepository()

    fun createUser(user: User) {
        if (service.isDuplicated(user)) {
            throw IllegalArgumentException()
        }

        repository.save(user)
    }

    fun changeUserInfo(user: User) {
        val target = repository.find(user)

//        if (target.isEmpty()) {
//            throw IllegalArgumentException("not found. target id: ${user.showId()}")
//        }
//
//        target.first().changeFullName(user.fullName)
//        repository.save(target.first())
    }

    fun showUsers(): List<User>{
        return repository.findAll()
    }
}