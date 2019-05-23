package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 2019年5月21日 10:50:24
 */
fun main() {
    println("主线程开始执行")

    GlobalScope.launch {
        println(Thread.currentThread().name)
        repeat(10) {
            println("打印了$it")
            Thread.sleep(500)
        }
    }

    println("主线程执行结束")

    Thread.sleep(5000)
    /* 输出结果:
    主线程开始执行
    主线程执行结束
    DefaultDispatcher-worker-2
    打印了0
    打印了1
    打印了2
    打印了3
    打印了4
    打印了5
    打印了6
    打印了7
    打印了8
    打印了9
     */
}