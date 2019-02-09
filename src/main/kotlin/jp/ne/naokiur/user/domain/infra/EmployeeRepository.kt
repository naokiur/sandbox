package jp.ne.naokiur.user.domain.infra

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

// Define Table for DSL and DAO
object Employees : IntIdTable() {
    val firstName: Column<String> = varchar("first_name", 60)
    val lastName: Column<String> = varchar("last_name", 60)
    val gender: Column<String> = varchar("gender", 1)
}

object EmployeeAttendances : IntIdTable() {
    val employeeId = reference("employee_id", Employees)
    val recordTime: Column<DateTime> = datetime("record_time")
    val attendType: Column<String> = varchar("attend_type", 1)
}

// Define Entity for DAO
class Employee(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Employee>(Employees)

    val firstName by Employees.firstName
    val lastName by Employees.lastName
    val gender by Employees.gender
}

class EmployeeAttendance(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<EmployeeAttendance>(EmployeeAttendances)

    val employeeId = EmployeeAttendances.employeeId
    val recordTime = EmployeeAttendances.recordTime
    val attendType = EmployeeAttendances.attendType
}

class EmployeeRepository {

    fun createTable() {
        Database.connect("jdbc:postgresql://localhost:15432/postgres",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "postgres_pass")

        transaction {
            SchemaUtils.create(Employees, EmployeeAttendances)
        }
    }
}