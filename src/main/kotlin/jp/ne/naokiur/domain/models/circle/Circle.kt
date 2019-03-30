package jp.ne.naokiur.domain.models.circle

import jp.ne.naokiur.domain.models.users.UserId

class Circle(val id: CircleId, val name: String, val userIds: MutableList<UserId>) {

    fun equals(other: Circle): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }

    fun join(userId: UserId) {
        if (userIds.count() >= 30) {
            throw Exception("too many members")
        }

        userIds.add(userId)
    }

//    fun notify(note: CircleNotification) {
//        note.id(id)
//        note.name(name)
//        note.users(mutableListOf(userIds))
//    }
}

class CircleId(val id: String) {

    fun equals(other: CircleId): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}
