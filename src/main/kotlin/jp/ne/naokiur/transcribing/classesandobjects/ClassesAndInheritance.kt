package jp.ne.naokiur.transcribing.classesandobjects

class ClassesAndInheritance {
    fun execute() {
        println("${this.javaClass.name} begin.")

        classes()
        constructors()

        println("${this.javaClass.name} end.")
    }

    private fun classes() {
        class Invoice {
            fun echo() {
                println("Invoice class")
            }
        }

        class Empty

        val invoice = Invoice()
        val empty = Empty()

        invoice.echo()
        println(empty)
    }

    private fun constructors() {
        fun primaryConstructor() {
            class Person constructor(firstName: String) {
                val name = firstName
                fun echo() {
//                    println(firstName) // Cannot Access
                    println(name)
                }
            }
            val person = Person("person")
            person.echo()

            class PersonAnother(firstName: String) {
                val name = firstName

                fun echo() {
//                    println(firstName) // Cannot Access
                    println(name)
                }
            }
            val personAnother = PersonAnother("person another")
            personAnother.echo()

            class InitOrderDemo(name: String) {
                val firstProperty = "First property: $name".also(::println)

                init {
                    println("First Initializer block that prints $name")
                }

                val secondProperty = "Second property: ${name.length}".also(::println)

                init {
                    println("Second initializer block that prints ${name.length}")
                }
            }

            val initOrderDemo = InitOrderDemo("init name")

            class Customer(name: String) {
                val customerKey = name.toUpperCase()
            }

            val customer = Customer("customer name")
            println(customer.customerKey)
        }
        primaryConstructor()

        fun secondaryConstructor() {
            // If the Class has primary constructor
            class Person(val name: String) {
                val children: MutableList<Person> = mutableListOf()

                constructor(name: String, parent: Person) : this(name) {
                    parent.children.add(this)
                }
            }

            val parent = Person("parent")
            val child = Person("child", parent)
            println(child.name)
            child.children.forEach { println(it.name)}

            println(parent.name)
            parent.children.forEach { println("child name is: ${it.name}")}

            class Constructors {
                init {
                    println("init block")
                }

                constructor(i: Int) {
                    println("constructor $i")
                }
            }
            val con = Constructors(1)

            class DontCreateMe private constructor () {
                fun echo() {
                    println("Don't Create Me echo")
                }
            }
//            val dont = DontCreateMe() // Cannot this
        }
        secondaryConstructor()
    }
}