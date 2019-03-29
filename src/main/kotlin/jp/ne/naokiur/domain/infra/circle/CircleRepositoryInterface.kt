package jp.ne.naokiur.domain.infra.circle

import jp.ne.naokiur.domain.models.circle.Circle
import jp.ne.naokiur.domain.models.circle.CircleId

interface CircleRepositoryInterface {
    fun save(circle: Circle)
    fun find(circleId: CircleId): Circle?
}