package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName

class UserRepository {
//    init {
    private val dataStore = mutableListOf(
            User(UserId(1), UserName("fuga"), FullName("hoge", "fuga")),
            User(UserId(2), UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    fun find(targetUser: User): User? {
        return dataStore.firstOrNull {
            user -> user.equals(targetUser)
        }
    }

    fun findAll(): List<User> {
        return dataStore
    }

    fun save(targetUser: User) {
        dataStore.add(targetUser)
    }
}