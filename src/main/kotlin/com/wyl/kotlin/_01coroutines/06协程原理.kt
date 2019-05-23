package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 同步和异步
 * 阻塞和非阻塞
 * 协程任务执行前后不一定是同一个线程
 */
fun main() = runBlocking {
    val job = GlobalScope.launch {
        val time = System.currentTimeMillis()
        println("线程执行前--- ${currentThreadName()}")

        // 等待 sleep() 非阻塞
        delay(2000)
//         Thread.sleep(2000) // 不能被挂起

        println("线程执行后--- ${currentThreadName()}  ${System.currentTimeMillis() - time}")


        /* 输出结果:
        线程执行前--- DefaultDispatcher-worker-1
        线程执行后--- DefaultDispatcher-worker-6  3006
         */
    }

    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        Thread.sleep(3000)
    }

    job.join()
}
