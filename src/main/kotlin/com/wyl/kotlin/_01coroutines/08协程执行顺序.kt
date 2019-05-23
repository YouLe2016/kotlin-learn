package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

fun main() = runBlocking {
    test1()
    test2()
}

private suspend fun test2() {
    val start = System.currentTimeMillis()
    println("主线程开始了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 0

    val job = GlobalScope.launch {
        println("协程开始了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")   // 1
        delay(1000)
        println("协程结束了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")   // 1017
    }

    println("主线程结束前 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 1
    job.join()
    println("主线程结束了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 1018
    /* 输出结果:
    主线程开始了 0
    主线程结束前 1
    协程开始了 1
    协程结束了 1017
    主线程结束了 1018
     */
}

private fun test1() {
    val start = System.currentTimeMillis()
    println("主线程开始了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 0

    val job = GlobalScope.launch {
        println("协程开始了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")   // 4
        sleep(1000)
        println("协程结束了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")   // 1004
    }

    println("主线程结束前 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 3
    sleep(3000)
    println("主线程结束了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 3003
    /* 输出结果:
    主线程开始了 0
    主线程结束前 3
    协程开始了 4
    协程结束了 1004
    主线程结束了 3003
     */
}