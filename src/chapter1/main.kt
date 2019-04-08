package chapter1

import kotlinx.coroutines.*

fun example1() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("hello,")
    Thread.sleep(2000L)
}


fun example2() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("hello,")
    runBlocking {
        delay(2000L)
    }
}

//更合乎runBlocking阻塞的用法
//使用runBlocking 可以在测试挂起函数
fun example3() = runBlocking<Unit> {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("hello,")
    delay(2000L)
}

fun example4() = runBlocking<Unit> {
    val job = GlobalScope.launch {
        println("world!")
    }
    println("hello,")
    delay(1L)
    println("over!")
    job.join()
}

//结构化并发
fun example5() = runBlocking {
    launch {
        delay(1000L)
        println("world!")
    }
    println("hello,")
}

//作用域构建器


//
fun example6() = runBlocking {

    runBlocking {
        delay(5000L)
        println("Task from nested launch")
    }
    println("Coroutine scope is over")
}

//提取函数重构
fun example7() = runBlocking {

        launch {
            doWorld()
        }
        println("Hello,")
}
 suspend fun doWorld() {
     delay(1000L)
     println("World!")
}

fun main() {
    example7()
}


