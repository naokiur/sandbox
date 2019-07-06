package jp.ne.naokiur.transcribing.classesandobjects

class LateInitializedPropertiesAndVariables {
    fun execute() {
        println("${this.javaClass.name} begin.")
        val t = MyTest()
        t.subject = MyTest.TestSubject() // Lazy Injection
        t.execute()

        println("${this.javaClass.name} end.")
    }

    class MyTest {
        lateinit var subject: TestSubject

        class TestSubject {
            fun method() {
                println("This is test subject method")
            }
        }

        fun execute() {
            subject.method()
        }
    }

}