package jp.ne.naokiur.domain.models.users

import jp.ne.naokiur.domain.models.circle.Circle
import jp.ne.naokiur.domain.models.circle.CircleFactoryInteface
import java.util.*

// 値オブジェクト
class UserId(val id: String) {

    fun equals(other: UserId): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}
class FullName constructor(val firstName: String, val familyName: String) {
    val name = "$firstName $familyName"

    fun equals(other: FullName): Boolean {

        val isSameRef = this === other

        return isSameRef || (this.firstName == other.firstName && this.familyName == other.familyName)
    }
}
class UserName constructor(val name: String) {
    init {
        if (name.length > 50) {
            throw IllegalArgumentException()
        }
    }

    fun equals(other: UserName): Boolean {

        val isSameRef = this === other

        return isSameRef || this.name == other.name
    }
}
//class FirstName constructor(val value: String)
//class LastName constructor(val value: String)

// エンティティ
class User constructor(
        val userId: UserId = UserId(UUID.randomUUID().toString()),
        var userName: UserName,
        var fullName: FullName
) {
    fun changeUserName(changed: UserName) {
        userName = changed
    }

    fun changeFullName(changed: FullName) {
        fullName = changed
    }

    fun equals(other: User): Boolean {
        val isSameRef = this === other

        return isSameRef || userId == other.userId
    }

    fun showId(): String {
        return userId.id
    }

    fun showFullName(): String {
        return fullName.name
    }

    fun create(circleFactory: CircleFactoryInteface, circleName: String): Circle {
        return circleFactory.create(this.userId, circleName)
    }
}

class UserModel(val id: String, val userName: String, val name: String)
class FullNameModel(val firstName: String, val lastName: String)
class UserSummaryModel(val id:String, val firstName: String)