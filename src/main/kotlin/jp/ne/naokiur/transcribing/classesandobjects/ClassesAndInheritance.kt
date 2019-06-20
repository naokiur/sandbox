package jp.ne.naokiur.transcribing.classesandobjects

class ClassesAndInheritance {
    fun execute() {
        println("${this.javaClass.name} begin.")

        classes()
        constructors()
        inheritance()
        overridingProperty()
        derivedClassInitializationOrder()
        callingTheSuperClassImplementation()

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

    private fun inheritance() {
        fun inheri() {
            open class Base(p: Int)

            class Derived(val p: Int) : Base(p)

            val derived = Derived(4)
            println(derived.p)
        }
        inheri()

        fun overrindingMethods() {
            open class Base {
                open fun v() {
                    println("Base v")
                }
                fun nv() {
                    println("Base nv")
                }
                open fun nvf() {
                    println("Base nv")
                }
            }
            class Derived: Base() {
                override fun v() {
                    println("Derived v")
                }
            }

            val derived = Derived()
            derived.v()
            derived.nv()

            open class AnotherDerived: Base() {
                final override fun v() {
                    println("AnotherDerived v")
                }

                override fun nvf() {
                    println("AnotherDerived nvf")
                }
            }
            class ChildAnotherDerived: AnotherDerived() {
                override fun nvf() {
                    println("ChildAnotherDerived nvf")
                }
            }

            val another = AnotherDerived()
            another.v()
            another.nv()
            another.nvf()

            val child = ChildAnotherDerived()
            child.v()
            child.nv()
            child.nvf()
        }
        overrindingMethods()
    }
    private fun overridingProperty() {
        open class Foo {
            open val x: Int get() { return 2 }
        }

        class Bar1: Foo() {
            override val x: Int
                get() = 5
        }

        val foo = Foo()
        println(foo.x)

        val bar1 = Bar1()
        println(bar1.x)

        class Bar2(override val count: Int) : FooInterface

        class Bar3 : FooInterface {
            override var count: Int = 0
        }

        val bar2 = Bar2(1000)
        println("bar2.count: ${bar2.count}")
//        bar2.count += 1 // Compile error because this is 'val'.

        val bar3 = Bar3()
        println("bar3.count: ${bar3.count}")
        bar3.count++ // Not Compile error because this is 'var'.
        println("bar3.count ${bar3.count}")
    }
    private fun derivedClassInitializationOrder() {
        open class Base(val name: String) {
            init { println("Initializing Base") }

            open val size: Int = name.length.also { println("Initializing size in Base: $it") }
        }

        class Derived(
                name: String,
                val lastName: String
        ): Base(name.capitalize().also { println("Argument for Base: $it") }) {
            init { println("Initializing Derived") }

            override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }

        }

        val derived = Derived("name", "lastName")
        println("derived.size: ${derived.size}")
    }
    private fun callingTheSuperClassImplementation() {
        open class Foo {
            open fun f() { println("Foo.f()") }
            open val x: Int get() = 1
        }

        class Bar: Foo() {
            override fun f() {
                super.f()
                println("Bar.f()")
            }

            override val x: Int get() = super.x + 1
        }

        val bar = Bar()
        bar.f()
        println("bar.x: ${bar.x}")

        class Bar2 : Foo() {
            override fun f() {
                super.f()
                println("Bar2.f()")
            }

            override val x: Int get() = 0

            inner class Baz {
                fun g() {
                    super@Bar2.f()
                    println(super@Bar2.x)
                }
            }
        }

        val bar2 = Bar2()
        bar2.f()
        println("bar2.x: ${bar2.x}")
        bar2.Baz().g()
    }
}

interface FooInterface {
    val count: Int
}
