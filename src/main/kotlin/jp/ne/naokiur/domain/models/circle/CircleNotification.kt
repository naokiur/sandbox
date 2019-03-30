package jp.ne.naokiur.domain.models.circle

import jp.ne.naokiur.domain.models.users.UserId

class CircleNotification(val id: CircleId, val name: String, val userIds: MutableList<UserId>) {
    fun build(): CircleDataModel {
        return CircleDataModel(
                id.id,
                name,
                userIds.map { x -> x.id }
        )
    }
}

class CircleDataModel(val id: String, val name: String, val userIds: List<String>)
