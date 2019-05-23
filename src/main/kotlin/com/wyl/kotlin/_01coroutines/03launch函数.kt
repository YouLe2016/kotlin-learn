package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 2019年5月21日 13:39:55
 * 目的: 协程其实也是在线程里面执行
 */
fun main() {
    /*
    launch函数是 协程启动 的入口
    参数: 前两个参数是默认参数, 最后一个参数是协程的执行函数
    context: CoroutineContext = EmptyCoroutineContext 协程上下文
        核心是由 ForkJoinPool 实现, 就是一个线程池
        就是指定协程是在哪一个线程或线程池
    返回值: Job 就是协程的任务
     */
    GlobalScope.launch {
        println("协程启动了..")
    }

    Thread.sleep(1000)

}