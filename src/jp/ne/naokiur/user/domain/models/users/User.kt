package jp.ne.naokiur.user.domain.models.users

// 値オブジェクト
class UserId {
    val id = hashCode()

    fun equals(userId: UserId): Boolean {
        return id == userId.id
    }
}
class FullName constructor(private val firstName: String, private val lastName: String) {
    val name = "$firstName $lastName"
}
class UserName constructor(val name: String) {
    init {
        if (name.length > 50) {
            throw IllegalArgumentException()
        }
    }
}
//class FirstName constructor(val value: String)
//class LastName constructor(val value: String)

// エンティティ
class User constructor(val userId: UserId, var userName: UserName, var fullName: FullName) {

    fun changeFullName(changed: FullName) {
        fullName = changed
    }

    fun equals(user: User): Boolean {
        return userId == user.userId
    }

    fun showId(): Int {
        return userId.id
    }

    fun showFullName(): String {
        return fullName.name
    }
}

