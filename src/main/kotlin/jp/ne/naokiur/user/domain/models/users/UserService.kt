package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.UserRepository
import jp.ne.naokiur.user.domain.infra.UserRepositoryInterface

class UserService(private val userRepository: UserRepositoryInterface) {

    fun isDuplicated(user: User): Boolean {
        val name = user.userName
        val searched = userRepository.find(name)

        return searched != null
    }
}