package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * 2019年5月21日 00:33:32
 */
fun main() {
    println("主线程开始执行")

    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        println("协程执行了")
    }

    println("主线程执行结束")

    Thread.sleep(1000)
    /* 输出结果:
    主线程开始执行
    主线程执行结束
    协程执行了
     */
}