package jp.ne.naokiur.transcribing.basics

import java.lang.Integer.parseInt

class ControlFlow {
    fun execute() {
        println("${this.javaClass.name} begin.")
        ifExpression()
        whenExpression()
        println("${this.javaClass.name} end.")
    }

    private fun ifExpression() {
        fun traditionalUsage() {
            val a = 10
            var max = a
            println("traditionalUsage max is: $max")

            val b = 20
            if (a < b) max = b
            println("traditionalUsage max is: $max")
        }

        fun withElse() {
            var max: Int
            val a = 10
            val b = 20

            if (a > b) {
                max = a
            } else {
                max = b
            }
            println("withElse max is: $max")
        }

        fun asExpression() {
            val a = 10
            val b = 20
            val max = if (a > b) a else b
            println("asExpression max is: $max")
        }

        traditionalUsage()
        withElse()
        asExpression()
    }
    private fun whenExpression() {

        fun normal() {
            val x = 1

            when (x) {
                1 -> println("x == 1")
                2 -> println("x == 2")
                else -> {
                    println("x is neither 1 nor 2")
                }
            }
        }
        normal()

        fun comma() {
            val x = 1
            when (x) {
                0, 1 -> println("x == 0 or x == 1")
                else -> println("otherwise")
            }
        }
        comma()

        fun arbitrary() {
            val x = 1
            val s = "1"

            when (x) {
                parseInt(s) -> println("s encodes x $x $s")
                else -> println("s does not encode x $x $s")
            }
        }
        arbitrary()

        fun checkRange() {
            val x = 1
            val validNumbers = listOf(1, 2, 3)
            when (x) {
                in 1..10 -> println("x is in the range $x")
                in validNumbers -> println("x is valid")
                !in 10..20 -> println("x is outside the range")
                else -> println("none of the above")
            }
        }
        checkRange()

        fun checkPaticularType() {
            fun hasPrefix(x: Any) = when(x) {
                is String -> x.startsWith("prefix")
                else -> false
            }

            println("prefixAAA: ${hasPrefix("prefixAAA")}")
            println("AAA: ${hasPrefix("AAA")}")
            println("1: ${hasPrefix(1)}")
        }
        checkPaticularType()

        fun ifElseIf() {
            val x = 1
            fun Int.isOdd(): Boolean {
                return true
            }
            fun Int.isEven(): Boolean {
                return false
            }

            when {
                x.isOdd() -> println("x is odd")
                x.isEven() -> println("x is even")
                else -> println("x is funny")
            }
        }
        ifElseIf()
    }
}