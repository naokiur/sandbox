package jp.ne.naokiur.user.domain.models.users

interface UserFactoryInterface {
    fun createUser(userName: UserName, fullName: FullName): User
}