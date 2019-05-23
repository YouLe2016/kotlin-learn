package com.wyl.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


var ticket = 100

fun main() {
    runBlocking {
        List(4) {
            GlobalScope.launch {
                while (ticket > 0) {
                    println("$it 号窗口: 卖出第 ${ticket--} 张票")
                    Thread.sleep(500)
                }
            }
        }.forEach { it.join() }
    }
}