package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.UserRepository

class UserService {
    private val userRepository = UserRepository()

    fun isDuplicated(user: User): Boolean {
        val name = user.userName
        val searched = userRepository.find(name)

        return searched != null
    }
}