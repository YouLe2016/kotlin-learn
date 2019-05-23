package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("主线程开始执行")

    val job = GlobalScope.launch {
        repeat(10) {
            println("${Thread.currentThread().name} 打印了$it")
            Thread.sleep(500)
        }
    }

    // 协程不执行的解决方案1: 主线程睡眠
//    Thread.sleep(1000)
    /* 输出结果:
    主线程开始执行
    DefaultDispatcher-worker-1 打印了0
    DefaultDispatcher-worker-1 打印了1
    主线程执行结束
     */

    // 协程不执行的解决方案1: job.join() [ fun main() = runBlocking ]
    job.join()
    /* 输出结果:
    主线程开始执行
    DefaultDispatcher-worker-1 打印了0
    DefaultDispatcher-worker-1 打印了1
    DefaultDispatcher-worker-1 打印了2
    DefaultDispatcher-worker-1 打印了3
    DefaultDispatcher-worker-1 打印了4
    DefaultDispatcher-worker-1 打印了5
    DefaultDispatcher-worker-1 打印了6
    DefaultDispatcher-worker-1 打印了7
    DefaultDispatcher-worker-1 打印了8
    DefaultDispatcher-worker-1 打印了9
    主线程执行结束
     */

    println("主线程执行结束")
}