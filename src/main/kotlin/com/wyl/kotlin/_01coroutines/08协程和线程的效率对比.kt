package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

/**
 * 2019年5月23日 10:40:22
 * 结论:
 * 协程和线程池的效率差不多 略低
 * 比开子线程的效率要高很多
 * 协程默认6个线程
 */
fun main() = runBlocking {
    val start = System.currentTimeMillis()
    println("主线程开始了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 0
    coroutines(start)
//    thread(start)
//    threadPool(start)

    println("主线程结束了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     //
}

/** 79 */
fun threadPool(start: Long) {
    val service = Executors.newFixedThreadPool(6)   // 79
//    val service = Executors.newCachedThreadPool() //184
//    val service = Executors.newScheduledThreadPool(6) // 100
//    val service = Executors.newSingleThreadExecutor() // 74
    val list = List(100000) {
        MyTask(start)
    }
    list.forEach { service.execute(it) }
}

/** 944 */
fun thread(start: Long) {
    val list = List(100000) {
        Thread(MyTask(start))
    }
    println("主线程结束前 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 1
    list.forEach { it.start() }
}

/** 主线程结束了 123 main */
private suspend fun coroutines(start: Long) {
    val list = List(100000) {
        GlobalScope.launch {
            MyTask(start).run()
        }
    }
    println("主线程结束前 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")     // 1
    list.forEach { it.join() }
}

class MyTask(private val start: Long) : Runnable {
    override fun run() {
        println("协程执行了 ${System.currentTimeMillis() - start} ${Thread.currentThread().name}")
    }
}
