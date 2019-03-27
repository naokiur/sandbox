package jp.ne.naokiur.domain.models.users

import jp.ne.naokiur.domain.infra.UserRepository


class UserFactory : UserFactoryInterface {
    private val repository = UserRepository()

    override fun createUser(userName: UserName, fullName: FullName): User {
        val newId = repository.nextIdentity()

        return User(newId, userName, fullName)
    }
}