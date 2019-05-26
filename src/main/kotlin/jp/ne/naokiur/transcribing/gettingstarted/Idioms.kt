package jp.ne.naokiur.transcribing.gettingstarted

class Idioms {
    fun execute() {
        println("${this.javaClass.name} begin.")
        creatingDtos()
        defaultValues()
        filteringAList()
        lazyProperty()
        extentionFunctions()


        println("${this.javaClass.name} end.")
    }

    private fun creatingDtos() {
        data class Customer(val name: String, val email: String)
        val customer = Customer(name = "Hoge", email = "hoge@example.com")
        println(customer.name)
        println(customer.hashCode())
        println(customer.toString())

        val copiedCustomer = customer.copy()
//        println("Original is equal to copied: ${customer.equals(copiedCustomer)}") // Suitable binary operator.
        println("Original is equal to copied: ${customer == copiedCustomer}")

    }

    private fun defaultValues() {
        fun foo(a: Int = 0, b: String = "") {
            println("a: $a, b: $b")
        }

        foo()
        foo(1, "fuga")
    }

    private fun filteringAList() {
        val list = listOf(-2, -1, 0, 1, 2, 3)
        val positives = list.filter { x -> x > 0 }
        println(positives)

        val shorterPositives = list.filter { it > 0 }
        println(shorterPositives)
    }

    private fun lazyProperty() {

        val lazy by lazy {
            val hashCode = "lazy".hashCode()
            "a b $hashCode"
        }
        println(lazy)
        println("this is object. ${lazy.javaClass}")

        // This is function.
        val notLazy = {
            val hashCode = "lazy".hashCode()
            "a b $hashCode"
        }
        println(notLazy)
        println("this is function ${notLazy.javaClass}")
        println(notLazy())
    }

    private fun extentionFunctions() {
//        fun String.spaceToCamelCase() {
//            println(it)
//        }

//        "Convert this to camelcase".spaceToCamelCase()
    }
}
