package jp.ne.naokiur.user.domain.applications

import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.models.users.*


//fun jp.ne.naokiur.api.main(args: Array<String>) {
//    showUsers()
//
//    val taroUser = User(userId = UserName(), userName = UserName("taro"), fullName = FullName("Tanaka", "Taro"))
//    createUser(taroUser)
//
//    showUsers()
//}

class UserApplicationService {
    private val service = UserService()
    private val repository = UserRepository()

    fun createUser(user: User) {
        if (service.isDuplicated(user)) {
            throw Exception("Duplicated!!")
        }

        repository.save(user)
    }

    fun changeUserInfo(user: User) {
        val target = repository.find(user.userName)

        // TODO remove null check
        if (target == null) {
            throw IllegalArgumentException("not found. target id: ${user.showId()}")
        }

        target.changeFullName(FullName(user.fullName.firstName, user.fullName.familyName))

        repository.save(target)
    }

//    fun showUsers(): List<User>{
//        return repository.findAll()
//    }

    fun showUser(userName: UserName): User? {
        return repository.find(userName)
    }
}