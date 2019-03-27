package jp.ne.naokiur.domain.models.circle

import jp.ne.naokiur.domain.models.users.UserId

interface CircleFactoryInteface {
    fun create(userId: UserId, name: String): Circle
}