package jp.ne.naokiur.user.domain.infra

import jp.ne.naokiur.user.domain.models.users.User
import jp.ne.naokiur.user.domain.models.users.UserName

interface UserRepositoryInterface {
    fun find(targetUserName: UserName): User?
    fun save(targetUser: User)
}