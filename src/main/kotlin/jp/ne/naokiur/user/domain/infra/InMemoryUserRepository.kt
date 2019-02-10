package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserName

class InMemoryUserRepository {
//    init {
    private val dataStore = mutableListOf(
            User(UserName("fuga"), FullName("hoge", "fuga")),
            User(UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    fun find(targetUserName: UserName): User? {
        return dataStore.firstOrNull {
            user -> user.userId.equals(targetUserName)
        }
    }

    fun findAll(): List<User> {
        return dataStore
    }

    fun save(targetUser: User) {
        if (dataStore.contains(targetUser)) {
            dataStore.remove(targetUser)
        }

        dataStore.add(targetUser)
    }
}