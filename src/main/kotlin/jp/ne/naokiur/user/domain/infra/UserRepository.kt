package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.FullName
import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserId
import jp.ne.naokiur.user.domain.models.users.UserName
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.NoSuchElementException

object TUser : Table("t_user") {
    val userId: Column<String> = varchar("user_id", 128).primaryKey()
    val userName: Column<String> = varchar("user_name", 30)
    val firstName: Column<String> = varchar("first_name", 30)
    val familyName: Column<String> = varchar("family_name", 30)
}

class UserRepository {
    val host = "jdbc:postgresql://localhost:15432/postgres"
    val driver = "org.postgresql.Driver"
    val dbUser = "postgres"
    val dbPassword = "postgres_pass"

    init {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            SchemaUtils.create(TUser)
        }
    }

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
                it[userId] = "a"
                it[firstName] = "hoge"
                it[familyName] = "piyo"
            }
        }
    }

    fun find(targetUserName: UserName): User? {
        Database.connect(host, driver, dbUser, dbPassword)

        return transaction {
            val query = TUser.select { TUser.userName eq targetUserName.name }
            val result = query.single()

            val userid = UserId(result[TUser.userId])
            val userName = UserName(result[TUser.userName])
            val fullName = FullName(result[TUser.firstName], result[TUser.familyName])

            User(userid, userName, fullName)
        }
//
//        return dataStore.firstOrNull { user ->
//            user.userId.equals(targetUserName)
//        }
    }
//
//    fun findAll(): List<User> {
//
//        return dataStore
//    }

    fun save(targetUser: User) {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            TUser.insert {
                it[userId] = targetUser.userId.id
                it[userName] = targetUser.userName.name
                it[firstName] = targetUser.fullName.firstName
                it[familyName] = targetUser.fullName.familyName
            }
        }
    }
}