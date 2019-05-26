package jp.ne.naokiur.transcribing.gettingstarted

class BasicSyntax {
    fun execute() {
        println("${this.javaClass.name} begin.")

        definingFunctions()
        definingVariables()
        usingTypeChecksAndAutomaticCasts()
        usingAForLoop()
        usingWhileLoop()
        usingWhenExpression()
        usingRanges()
        usingCollections()

        println("${this.javaClass.name} end.")
    }

    private fun definingFunctions() {
        // Defining functions
        fun sum(a: Int, b: Int): Int {
            return a + b
        }
        println(sum(1, 3))

        fun sumOneLiner(a: Int, b: Int): Int = a + b
        println(sumOneLiner(1, 3))

        fun printSum(a: Int, b: Int) {
            // private fun printSum(a: Int, b: Int): Unit { // "Unit" is redundant.
            println("sum of $a + and $b is ${a + b}")
        }
        printSum(1, 3)

    }

    private fun definingVariables() {
        val a: Int = 1
        val b = 2
        val c: Int
        c = 3

        println("a = $a, b = $b, c = $c")

        val PI = 3.14
        var x = 0
        fun incrementX() {
            x += 1
        }
        incrementX()
        println(x)
        incrementX()
        println(x)
        incrementX()
        println(x)
    }

    private fun usingTypeChecksAndAutomaticCasts() {
        fun getStringLength(obj: Any): Int? {
            if (obj !is String) return null

            return obj.length
        }

        println(getStringLength("Using type checks and automatic casts"))
        println(getStringLength(Any()))
    }

    private fun usingAForLoop() {
        val items = listOf("apple", "banana", "kiwifruit")

        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    private fun usingWhileLoop() {
        val items = listOf("apple", "banana", "kiwifruit")
        var index = 0

        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    private fun usingWhenExpression() {
        fun describe(obj: Any): String =
                when(obj) {
                    1 -> "One"
                    "Hello" -> "Greeting"
                    is Long -> "Long"
                    !is String -> "Not a string"
                    else -> "Unknown"
                }

        println(describe(1))
        println(describe("Hello"))
        println(describe(Long.MAX_VALUE))
        println(describe(Int.MIN_VALUE))
        println(describe("else"))
    }

    private fun usingRanges() {
        val x = 10
        val y = 9
        if (x in 1..y+1) {
            println("fits in range")
        }

        val list = listOf("a", "b", "c")
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range, too")
        }

        for (x1 in 1..5) {
            println(x1)
        }

        for (x2 in 1..10 step 2) {
            println(x2)
        }
        println()
        for (x3 in 9 downTo 0 step 3) {
            println(x3)
        }
    }

    private fun usingCollections() {
        val items = listOf("apple", "banana", "kiwifruit", "avocado")
        for (item in items) {
            println(item)
        }

        when {
            "orange" in items -> println("juicy")
            // if match, this statement will be break.
            "apple" in items -> println("apple is fine too")
            "banana" in items -> println("banana is fine too")
        }

        items.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

}
