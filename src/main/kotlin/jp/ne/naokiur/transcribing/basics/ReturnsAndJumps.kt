package jp.ne.naokiur.transcribing.basics

import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class ReturnsAndJumps {
    fun execute() {
        println("${this.javaClass.name} begin.")

        largerExpressions()
        breakAndContinueLabels()
        returnAtLabel()

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

        fun withOutLabel() {
            println("withOutLabel")
            for (i in 1..10) {
                for (j in 1..100) {
                    if (j == 2) {
                        break
                    }
                    println("i: $i, j: $j")
                }
            }
        }
        withOutLabel()

        fun withLabael() {
            println("withLabel")

            loop@ for (i in 1..10) {
                for (j in 1..100) {
                    if (j == 2) {
                        break@loop
                    }
                    println("i: $i, j: $j")
                }
            }
        }
        withLabael()
    }

    private fun returnAtLabel() {
        fun withOutLabel() {
            println("withOutLabel")
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3 ) return
                println(it)
            }
            println("this point is unreachable")
        }
        withOutLabel()

        fun withLabel() {
            println("withLabel")
            listOf(1, 2, 3, 4, 5).forEach lit@{
                if (it == 3 ) return@lit
                println(it)
            }

            println("done with explicit label")
        }
        withLabel()

        fun withAnonymousFunction() {
            println("withAnonymousFunction")
            listOf(1, 2, 3, 4, 5).forEach(fun (value: Int){
                if (value == 3) return
                println(value)
            })

            println("done with anonymous function")
        }
        withAnonymousFunction()

        fun nestedLoop() {
            println("nestedLoop")
            run loop@{
                listOf(1, 2, 3, 4, 5).forEach {
                    if (it == 3) return@loop
                    println(it)
                }
            }

            println("done with nested loop")
        }
        nestedLoop()
    }
}