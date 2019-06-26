package jp.ne.naokiur.transcribing.classesandobjects

class PropertiesAndFields {
    fun execute() {
        println("${this.javaClass.name} begin.")

        getterAndSetter()
        backingFields()

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
    // Kotlinはフィールドではなく、プロパティである
    private fun backingFields() {
        class Count {
            // 暗黙的にバッキングフィールドを生成している例
            var counter = 0
                set(value) {
                    if (value >= 0) {
                        field = value
                    }
                }
            // 暗黙的にバッキングフィールドを生成していない例
            val isEmpty: Boolean
                get() = this.counter == 0

//            // 暗黙的にバッキングフィールドを生成していない例
//            val isEmpty2: Boolean = false
//                get() = !field
        }

        val count = Count()
        println("count.counter: ${count.counter}")
        count.counter = 5
        println("count.counter after set 5: ${count.counter}")
        count.counter = -1
        println("count.counter after set -1: ${count.counter}")
        println("count.isEmpty: ${count.isEmpty}")
    }
}