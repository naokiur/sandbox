package jp.ne.naokiur.domain.models.users

import jp.ne.naokiur.domain.infra.user.UserRepositoryInterface

class UserService(private val userRepository: UserRepositoryInterface) {

    fun isDuplicated(user: User): Boolean {
        val name = user.userName
        val searched = userRepository.find(name)

        return searched != null
    }
}