package jp.ne.naokiur.domain.infra.circle

import jp.ne.naokiur.domain.infra.user.TUser
import jp.ne.naokiur.domain.models.circle.Circle
import jp.ne.naokiur.domain.models.circle.CircleId
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TCircle : Table("t_circle") {
    val circleId: Column<String> = TUser.varchar("circle_id", 128).primaryKey()
    val circleName: Column<String> = TUser.varchar("circle_name", 30)
    val joinMembers: Column<String> = TUser.varchar("first_name", 60000)
}

class CircleRepository: CircleRepositoryInterface{
    private val host = "jdbc:postgresql://localhost:15432/postgres"
    private val driver = "org.postgresql.Driver"
    private val dbUser = "postgres"
    private val dbPassword = "postgres_pass"

    init {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            SchemaUtils.create(TCircle)
        }
    }

    override fun save(circle: Circle) {
        Database.connect(host, driver, dbUser, dbPassword)

        transaction {
            TCircle.update({ TCircle.circleId eq circle.id.id }) {
                it[TCircle.circleName] = circle.name
                it[TCircle.joinMembers] = circle.userIds.joinToString(",")
            }
        }
    }

    override fun find(circleId: CircleId): Circle? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}