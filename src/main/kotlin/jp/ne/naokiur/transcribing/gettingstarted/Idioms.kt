package jp.ne.naokiur.transcribing.gettingstarted

import java.io.File

class Idioms {
    fun execute() {
        println("${this.javaClass.name} begin.")
        creatingDtos()
        defaultValues()
        filteringAList()
        lazyProperty()
        extensionFunctions()
        creatnigAShingleton()
        ifNotNullShortHand()
        getFirstItemOfAPossibilyEmptyCollection()
        executeIfNotNull()

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

    private fun extensionFunctions() {
        fun String.spaceRemovePrint() {
            println(this.replace(" ", ""))
        }

        "Convert this to camelcase".spaceRemovePrint()
    }
    object Resource {
        const val name = "Name"
    }
    class ResourceClass {
        val name = "Name"
    }
    private fun creatnigAShingleton() {
        val name1FromObject = Resource
        val name2FromObject = Resource

        val name1 = ResourceClass()
        val name2 = ResourceClass()
        println("Class diff is : ${name1 == name2}")
        println("Object diff is : ${name1FromObject == name2FromObject}")
    }
    private fun ifNotNullShortHand() {
        val files = File("Test").listFiles()
        println(files?.size)
        println(files?.size ?: "empty")
//        println(files?.size ?: throw IllegalStateException("Empty Exception"))
    }
    private fun getFirstItemOfAPossibilyEmptyCollection() {
        val emails = emptyList<String>()
        val mainEmail = emails.firstOrNull() ?: ""
        println(mainEmail)
    }
    private fun executeIfNotNull() {
        var value = "aaa"
        value?.let {
            println("Not null")
        }
        // I want to get null. Confirm idiom.
        val lists = File("Test").listFiles()
        lists?.let {
            println("Not null")
        }

        // I want to get null. Confirm idiom.
        val map = File("Test").listFiles()
        val mapped = map?.let { it.first()  } ?: mapOf(Pair(1, "one"))
        println(mapped)
    }

}
