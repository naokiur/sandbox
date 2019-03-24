package jp.ne.naokiur.user.domain.models.users

import jp.ne.naokiur.user.domain.infra.TUser
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TSeq : Table("t_seq") {
    val id: Column<Int> = integer("id")
}

class UserFactory: UserFactoryInterface {
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

    override fun createUser(userName: UserName, fullName: FullName): User {
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

        return User(UserId(seqId), userName, fullName)
    }
}