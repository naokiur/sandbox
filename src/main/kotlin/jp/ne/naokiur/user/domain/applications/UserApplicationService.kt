package jp.ne.naokiur.user.domain.applications

import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.infra.UserRepositoryInterface
import jp.ne.naokiur.user.domain.models.users.*


//fun jp.ne.naokiur.api.main(args: Array<String>) {
//    showUsers()
//
//    val taroUser = User(userId = UserName(), userName = UserName("taro"), fullName = FullName("Tanaka", "Taro"))
//    createUser(taroUser)
//
//    showUsers()
//}

class UserApplicationService(
        private val service: UserService,
        private val repository: UserRepositoryInterface
) {

    fun createUser(userName: String , firstName: String, familyName: String) {
        val targetUser = User(
                UserName(userName),
                FullName(firstName, familyName)
        )

        if (service.isDuplicated(targetUser)) {
            print("This user is duplicated!!")
            return
        }

        repository.save(targetUser)
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