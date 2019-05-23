package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 2019年5月21日 17:03:01
 * 挂起函数: 可以被挂起执行 到时间之后从线程池中空闲的线程中恢复执行
 * 挂起函数必须通过 suspend 修饰   suspend: 延缓
 * 挂起函数必须在协程中执行 或者 在其他挂起函数中执行
 * suspend函数不会阻塞线程, sleep()将会阻塞当前线程
 */
fun main() = runBlocking {
    // 主协程
    val job = GlobalScope.launch {
        doTask()
    }

    job.join()
}

suspend fun doTask() {
    val time = System.currentTimeMillis()
    println("线程执行前--- ${currentThreadName()}")

    delay(2000)

    println("线程执行后--- ${currentThreadName()}  ${System.currentTimeMillis() - time}")
}

fun currentThreadName() = Thread.currentThread().name