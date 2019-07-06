package jp.ne.naokiur.api

import kotlin.test.Test

class ApiTest {

//    @Test
//    fun testHello() = withTestApplication(Application::api) {
//        handleRequest(HttpMethod.Get, "/")
//    }

//    @Test
//    fun testHello() = withTestApplication(Application::api) {
//            handleRequest(HttpMethod.Get, "/").run {
//            assertEquals(HttpStatusCode.OK, response.status())
//            assertEquals("Hello, world!", response.content)
//        }
//        handleRequest(HttpMethod.Get, "/") {
//            println("aa")
//        }.run {
//            println("aa")
//        }
//    }
    @Test
    fun testExtention() = extentionModuleFun(ExtentionItem::show) {
        println("execute")
    }

    @Test
    fun testFunction() {
//        defineFunction()
//        println(bow())
        needFun {
            println(bow())
        }
    }

    @Test
    fun testFunctionReturn() {
//        println(functionReturn())
        val rec = fun Int.(arg: Int): Int = this + arg
        functionReturn2(rec).run {
            println("aaaa")
        }
//        defineFunction()
    }
}

fun functionReturn(): Int {
    return 1
}

fun needFun(dogMethod: Dog.() -> Unit) {
//    println(dogMethod)
    dogMethod(Dog())
}

//fun functionReturn2(rec: Int.(arg: Int) -> Int): Int {
//    return 2.rec(1)
//}
fun functionReturn2(rec: Int.(arg: Int) -> Int) {
    println(2.rec(1))
}

fun defineFunction() = printTest()

fun printTest() {
    println("Test")
}

class ExtentionItem {
    val name: String = "aaa"

    fun show() {
        println(name)
    }

    fun register() {
        println("register")
    }
}


fun extentionModuleFun(moduleFunction: ExtentionItem.() -> Unit, test: ExtentionItem.() -> Unit) {
//    return moduleFunction(ExtentionItem())
    return extentionModuleConf {
        moduleFunction()
        test()
    }
}

fun extentionModuleConf(moduleFunction: ExtentionItem.() -> Unit) {
//    return moduleFunction(ExtentionItem())
    println("config")
    moduleFunction(ExtentionItem())
}


class Dog {
    val name = "pochi"
}

fun Dog.bow(): String = name