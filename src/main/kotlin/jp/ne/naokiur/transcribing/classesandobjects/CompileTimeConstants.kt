package jp.ne.naokiur.transcribing.classesandobjects

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is duplicated"

class CompileTimeConstants {
//    const val SUBSYSTEM_DEPRECATED: String = "This subsystem is duplicated" // cannot this.


    fun execute() {
        println("${this.javaClass.name} begin.")
        println(SUBSYSTEM_DEPRECATED)
        foo()

        println("${this.javaClass.name} end.")
    }

    @Deprecated(SUBSYSTEM_DEPRECATED, replaceWith = ReplaceWith("another"))
    private fun foo() {
        println(SUBSYSTEM_DEPRECATED)
    }

}