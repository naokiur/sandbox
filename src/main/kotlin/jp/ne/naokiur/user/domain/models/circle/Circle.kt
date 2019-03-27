package jp.ne.naokiur.user.domain.models.circle

class Circle(val id: CircleId, val name: String) {

}

class CircleId(val id:String) {

    fun equals(other: CircleId): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}
