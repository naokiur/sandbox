package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.UserRepository


class UserFactory : UserFactoryInterface {
    private val repository = UserRepository()

    override fun createUser(userName: UserName, fullName: FullName): User {
        val newId = repository.nextIdentity()

        return User(newId, userName, fullName)
    }
}