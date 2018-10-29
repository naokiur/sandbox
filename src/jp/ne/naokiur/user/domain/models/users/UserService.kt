package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.UserRepository

class UserService {
    private val userRepository = UserRepository()

    fun isDuplicated(user: User): Boolean {
        val existUser = userRepository.find(user)
        return  existUser.isNotEmpty()
    }

    fun register(user: User) {
        userRepository.save(user)
    }

    fun showUsers() {
        val userList = userRepository.findAll()
        for (user in userList) {
            println("id: ${user.showId()}, fullName: ${user.showFullName()}")
        }
    }
}