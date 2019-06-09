package jp.ne.naokiur.transcribing.basics

class ReturnsAndJumps {
    fun execute() {
        println("${this.javaClass.name} begin.")

        largerExpressions()

        println("${this.javaClass.name} end.")
    }

    private fun largerExpressions() {
        val person = null
        fun expressions(person: String?) {
            person ?: return
        }
        val s  = expressions(person)
        println(s)
    }

    private fun breakAndContinueLabels() {

    }


}