package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.*

class InMemoryUserRepository: UserRepositoryInterface {
    private val factory = InMemoryUserFactory()
    //    init {
    private val dataStore = mutableListOf(
            factory.createUser(UserName("fuga"), FullName("hoge", "fuga")),
            factory.createUser(UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    override fun find(targetUserId: UserId): User? {
        return dataStore.firstOrNull {
            user -> user.userId.equals(targetUserId)
        }
    }

    override fun find(targetUserName: UserName): User? {
        return dataStore.firstOrNull {
            user -> user.userName.equals(targetUserName)
        }
    }

    override fun findAll(): List<User> {
        return dataStore
    }

    override fun save(targetUser: User) {
        dataStore.add(targetUser)
    }

    override fun remove(targetUser: User) {
        dataStore.remove(targetUser)
    }
}