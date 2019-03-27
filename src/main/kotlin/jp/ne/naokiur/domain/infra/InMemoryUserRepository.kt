package jp.ne.naokiur.domain.infra

import jp.ne.naokiur.domain.models.users.FullName
import jp.ne.naokiur.domain.models.users.User
import jp.ne.naokiur.domain.models.users.UserId
import jp.ne.naokiur.domain.models.users.UserName
import jp.ne.naokiur.user.domain.models.users.*

class InMemoryUserRepository: UserRepositoryInterface {
    private var currentId = 1

        //    init {
    private val dataStore = mutableListOf(
                User(nextIdentity(), UserName("fuga"), FullName("hoge", "fuga")),
                User(nextIdentity(), UserName("puyo"), FullName("hoge", "piyo"))
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

    override fun nextIdentity(): UserId {
        currentId++

        return UserId(currentId.toString())
    }
}