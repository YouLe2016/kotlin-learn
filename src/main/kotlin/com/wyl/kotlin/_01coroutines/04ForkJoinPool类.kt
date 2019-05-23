package com.wyl.kotlin._01coroutines

import java.util.concurrent.ForkJoinPool

/**
 * 2019年5月21日 15:58:49
 * ForkJoinPool
 *
 * 总结:
 * 普通线程池 创建的是用户线程, 主线程结束 子线程继续执行
 * ForkJoinPool 创建的是守护线程, 主线程结束 子线程也结束了
 *
 */
fun main() {
    println("主线程开始执行")

    // 常规线程池执行
    /*val service = Executors.newFixedThreadPool(3)
    val task = Task()
    service.execute(task)*/

    // ForkJoinPool
    val service = ForkJoinPool(3)
    val task = Task()
    service.execute(task)
    Thread.sleep(2000)

    println("主线程执行结束")

}

class Task : Runnable {
    override fun run() {
        repeat(10) {
            println("${Thread.currentThread().name} $it")
            Thread.sleep(500)
        }
    }
}