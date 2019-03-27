package jp.ne.naokiur.domain.models.circle

class Circle(val id: CircleId, val name: String) {

    fun equals(other: Circle): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}

class CircleId(val id: String) {

    fun equals(other: CircleId): Boolean {
        val isSameRef = this === other

        return isSameRef || this.id == other.id
    }
}
