package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 2019年5月23日 11:29:22
 * Deferred<T>:Job
 * launch: 没有返回值
 * async: 有返回值
 */
fun main() = runBlocking {
    //    val launch = GlobalScope.launch { job1() }
    //    println("获取到了launch的返回值: ")

    val async1 = GlobalScope.async { job1() }
    val async2 = GlobalScope.async { job2() }

    val result1 = async1.await()    // 执行完之后才能获取到数据
    val result2 = async2.await()
    println(result1)
    println(result2)
    /* 打印结果:
    job1 start---
    job2 start---
    job1 end---
    job2 end---
    job1
    job2
     */

}

fun job1(): String {
    val str = "job1"
    println("$str start---")
//    delay(1000)
    Thread.sleep(1000)
    println("$str end---")
    return str
}

suspend fun job2(): String {
    val str = "job2"
    println("$str start---")
    delay(1000)
    println("$str end---")
    return str
}