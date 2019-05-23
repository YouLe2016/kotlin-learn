package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        withTimeout(2000) {
            repeat(10) {
                if (!isActive) return@withTimeout
                println("打印$it")
                Thread.sleep(500)
            }
        }
    }
    job.join()
}