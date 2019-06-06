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
        returnOnWhenStatement()
        tryCatchException()
        ifExpression()
        builderStyleUsageOfMethodsThatReturnUnit()
        singleExpressionFunctions()
        callingMultipleMethodsOnAnObjectInstance()
        consumingANullableBoolean()
        swappingTwoVariables()

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
    private fun returnOnWhenStatement() {
        fun transform(color: String): Int {
            return when (color) {
                "Red" -> 0
                "Green" -> 1
                "Blue" -> 2
                else -> throw IllegalArgumentException("Invalid color param value")
            }
        }

        println("Red is : ${transform("Red")}")
    }
    private fun tryCatchException() {
        val result = try {
            println("result")
            throw ArithmeticException("throw ArithmeticException")
        } catch (e: ArithmeticException) {
            println(e)
        }

        println(result)
    }
    private fun ifExpression() {
        fun foo(param: Int) {
            val result = if (param == 1) {
                "one"
            } else if (param == 2) {
                "two"
            } else {
                "three"
            }
            println(result)
        }
        foo(1)
    }
    private fun builderStyleUsageOfMethodsThatReturnUnit() {
        fun arrayOfMinusOnes(size: Int): IntArray {
            return IntArray(size).apply { fill(-1) }
        }

        val lists = arrayOfMinusOnes(3)
        lists.map { println(it) }
    }
    private fun singleExpressionFunctions() {
        fun theAnswer() = 42
        println(theAnswer())

        fun theAnswer2(): Int {
            return 42
        }
        println(theAnswer2())
    }
    private fun callingMultipleMethodsOnAnObjectInstance() {
        class Turtle {
            fun penDown() = println("penDown")
            fun penUp() = println("penUp")
            fun turn(degree: Double) = println("turn $degree")
            fun forward(pixels: Double) = println("forward $pixels")
        }

        val myTurtle = Turtle()
        with(myTurtle) {
            penDown()
            for (i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }
    }
    private fun consumingANullableBoolean() {
        fun returnNullable(isNull: Boolean): Boolean? {
            return if (isNull) null else true
        }
        val b: Boolean? = returnNullable(true)

        if (b == true) {
            println("b is true: $b")
        } else {
            println("b is false or null: $b")
        }
    }
    private fun swappingTwoVariables() {
        var a = 1
        var b = 2

        a = b.also { b = a }
        println("a is $a, b is $b")
    }
}
