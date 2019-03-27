package jp.ne.naokiur.domain.infra.circle

import jp.ne.naokiur.domain.models.circle.Circle

interface CircleRepositoryInterface {
    fun save(circle: Circle)
}