package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName

class UserRepository {
//    init {
    private val dataStore = mutableListOf(
            User(UserId(), UserName("fuga"), FullName("hoge", "fuga")),
            User(UserId(), UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    fun find(targetUser: User): User {
        return dataStore.first {
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