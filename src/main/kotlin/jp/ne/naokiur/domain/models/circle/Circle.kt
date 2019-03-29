package jp.ne.naokiur.domain.models.circle

import jp.ne.naokiur.domain.models.users.User
import jp.ne.naokiur.domain.models.users.UserId

class Circle(val id: CircleId, val name: String, val users: MutableList<UserId>) {

    fun equals(other: Circle): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }

    fun join(userId: UserId) {
        if (users.count() >= 30) {
            throw Exception("too many members")
        }

        users.add(userId)
    }
}

class CircleId(val id: String) {

    fun equals(other: CircleId): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}