package jp.ne.naokiur.transcribing.classesandobjects

class PropertiesAndFields {
    fun execute() {
        println("${this.javaClass.name} begin.")

        getterAndSetter()

        println("${this.javaClass.name} end.")
    }
    private fun getterAndSetter() {
        class Address {
//            var allByDefault: Int? error need initialize
            var initialized = 1
//            val simple: Int? // has type Int, default getter, must be initialized in constructor
            val inferredType = 1
            val isEmpty: Boolean
                get() = this.initialized == 0
            var stringRepresentation: String
                get() = this.toString()
                set(value) {
                    another = value
                }
            var another = ""
            val isEmptySince1_1 get() = this.initialized == 0
            var setterVisibility: String = "abc"
                private set
//            var setterWithAnnotation: Any? = null
//                @Inject set

        }
        val address = Address()
        println("address.initialized: ${address.initialized}")
        println("address.inferredType: ${address.inferredType}")
        println("address.isEmpty: ${address.isEmpty}")
        println("address.stringRepresentation: ${address.stringRepresentation}")
        println("address.another: ${address.another}")
        address.stringRepresentation = "aaa"
        println("address.another after: ${address.another}")
        println("address.isEmptySince1_1: ${address.isEmptySince1_1}")
        println("address.setterVisibility: ${address.setterVisibility}")
//        address.setterVisibility = "ddd" // cannot this

    }
}