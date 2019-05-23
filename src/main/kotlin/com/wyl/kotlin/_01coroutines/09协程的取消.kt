package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.*

/**
 * 2019年5月23日 10:48:05
 * 只能取消挂起函数, 不能取消阻塞函数
 */
fun main() = runBlocking {
//    method1()
//    method2()
}

private suspend fun method2() {
    val job = GlobalScope.launch {
        repeat(10) {
            println("打印$it")
            delay(500)
        }
    }

    delay(2000)
    job.cancel()
    job.join()
}

private suspend fun method1() {
    val job = GlobalScope.launch {
        withTimeout(2000) {
            repeat(10) {
                println("打印$it")
                delay(500)
            }
        }
    }

    job.join()
}