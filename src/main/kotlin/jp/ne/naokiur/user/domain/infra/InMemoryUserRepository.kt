package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName

class InMemoryUserRepository {
//    init {
    private val dataStore = mutableListOf(
            User(UserId(1), UserName("fuga"), FullName("hoge", "fuga")),
            User(UserId(2), UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    fun find(targetUserId: UserId): User? {
        return dataStore.firstOrNull {
            user -> user.userId.equals(targetUserId)
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