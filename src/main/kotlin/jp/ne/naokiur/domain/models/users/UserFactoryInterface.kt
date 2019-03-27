package jp.ne.naokiur.domain.models.users

interface UserFactoryInterface {
    fun createUser(userName: UserName, fullName: FullName): User
}