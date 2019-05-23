package com.wyl.kotlin._01coroutines

import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 2019年5月23日 18:01:03
 * 协程上下文:
 *  指定协程代码是在哪个线程池中执行
 */
fun main() {
    GlobalScope.launch(Unconfined) {

    }
    GlobalScope.launch(Main) {

    }
}