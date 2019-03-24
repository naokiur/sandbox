package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.plus
import org.jetbrains.exposed.sql.transactions.transaction

object TUser : Table("t_user") {
    val userId: Column<String> = varchar("user_id", 128).primaryKey()
    val userName: Column<String> = varchar("user_name", 30)
    val firstName: Column<String> = varchar("first_name", 30)
    val familyName: Column<String> = varchar("family_name", 30)
}

object TSeq : Table("t_seq") {
    val id: Column<Int> = integer("id")
}

class UserRepository: UserRepositoryInterface {

    val host = "jdbc:postgresql://localhost:15432/postgres"
    val driver = "org.postgresql.Driver"
    val dbUser = "postgres"
    val dbPassword = "postgres_pass"

    init {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            SchemaUtils.create(TUser)
            SchemaUtils.create(TSeq)

            val isEmptySeqRecord = TSeq.selectAll().empty()
            if (isEmptySeqRecord) {
                TSeq.insert { it[id] = 1 }
            }
        }
    }

    override fun find(targetUserId: UserId): User? {
        Database.connect(host, driver, dbUser, dbPassword)

        return transaction {
            val query = TUser.select { TUser.userId eq targetUserId.id }
            query.singleOrNull()
        }?.let {
            val userId = UserId(it[TUser.userId])
            val userName = UserName(it[TUser.userName])
            val fullName = FullName(it[TUser.firstName], it[TUser.familyName])

            User(userId, userName, fullName)
        }
    }

    override fun find(targetUserName: UserName): User? {
        Database.connect(host, driver, dbUser, dbPassword)

        return transaction {
            val query = TUser.select { TUser.userName eq targetUserName.name }
            query.singleOrNull()
        }?.let {
            val userId = UserId(it[TUser.userId])
            val userName = UserName(it[TUser.userName])
            val fullName = FullName(it[TUser.firstName], it[TUser.familyName])

            User(userId, userName, fullName)
        }
    }

    override fun findAll(): List<User> {
        Database.connect(host, driver, dbUser, dbPassword)

        return transaction {
            TUser.selectAll().map {
                User(
                        UserId(it[TUser.userId]),
                        UserName(it[TUser.userName]),
                        FullName(it[TUser.firstName], it[TUser.familyName])
                )
            }
        }
    }

    override fun save(targetUser: User) {
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

    override fun remove(targetUser: User) {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            TUser.deleteWhere { TUser.userId eq targetUser.userId.id }
        }
    }

    override fun nextIdentity(): UserId {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            TSeq.update {
                with(SqlExpressionBuilder) {
                    it.update(TSeq.id, TSeq.id + 1)
                }
            }
        }

        val seqId = transaction {
            TSeq.selectAll().first().toString()
        }

        return UserId(seqId)
    }
}