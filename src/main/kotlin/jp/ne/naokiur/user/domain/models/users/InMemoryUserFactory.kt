package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.TUser
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


class InMemoryUserFactory: UserFactoryInterface {
    private var currentId = 1

    override fun createUser(userName: UserName, fullName: FullName): User {
        currentId++

        return User(UserId(currentId.toString()), userName, fullName)
    }
}