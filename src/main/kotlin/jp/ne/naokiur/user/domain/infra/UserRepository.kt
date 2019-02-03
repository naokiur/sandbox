package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TUser : Table("t_user") {
    val userId: Column<Int> = integer("user_id").primaryKey()
    val firstName: Column<String> = varchar("first_name", 30)
    val lastName: Column<String> = varchar("last_name", 30)
}

class UserRepository {
    //    init {
    private val dataStore = mutableListOf(
            User(UserId(1), UserName("fuga"), FullName("hoge", "fuga")),
            User(UserId(2), UserName("puyo"), FullName("hoge", "piyo"))
    )
//    }

    fun connect() {
        println("Repo connect")
        Database.connect("jdbc:postgresql://localhost:15432/postgres",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "postgres_pass")

        transaction {
//            for (user in users) {
//                println(user)
//            }
            TUser.insert {
                it[userId] = 11
                it[firstName] = "hoge"
                it[lastName] = "piyo"
            }
        }
    }

    fun find(targetUserId: UserId): User? {
        return dataStore.firstOrNull { user ->
            user.userId.equals(targetUserId)
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