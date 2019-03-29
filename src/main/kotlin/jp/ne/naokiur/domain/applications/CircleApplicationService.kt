package jp.ne.naokiur.domain.applications

import jp.ne.naokiur.domain.infra.circle.CircleRepositoryInterface
import jp.ne.naokiur.domain.infra.user.UserRepositoryInterface
import jp.ne.naokiur.domain.models.circle.CircleFactoryInteface
import jp.ne.naokiur.domain.models.circle.CircleId
import jp.ne.naokiur.domain.models.users.User
import jp.ne.naokiur.domain.models.users.UserId
import java.lang.Exception

class CircleApplicationService(
        val circleFactory: CircleFactoryInteface,
        val circleRepository: CircleRepositoryInterface,
        val userRepository: UserRepositoryInterface
) {
    fun createCircle(userId: String, circleName: String) {
        val ownerId = UserId(userId)
        val owner = userRepository.find(ownerId)

        if (owner == null) {
            throw Exception("Owner is not found. userId: $userId")
        }

        val circle = owner.create(circleFactory, circleName)
        circleRepository.save(circle)
    }

    fun joinUser(circleId: String, userId: String) {

        val targetCircleId = CircleId(circleId)
        val targetCircle = circleRepository.find(targetCircleId)

        if (targetCircle == null) {
            throw Exception("Circle is not found. circleId: $circleId")
        }

        val joinUserId = UserId(userId)
        val joinUser = userRepository.find(joinUserId)

        if (joinUser == null) {
            throw Exception("Owner is not found. userId: $userId")
        }

        targetCircle.join(joinUserId)
        circleRepository.save(targetCircle)
    }
}