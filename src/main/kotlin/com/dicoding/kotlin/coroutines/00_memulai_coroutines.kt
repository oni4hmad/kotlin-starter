package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.*

// MATERI: memulai coroutines

/*
runBlocking: coroutine utama
launch: coroutine baru
*/

fun main() = runBlocking{
    launch {
        delay(1000L)
        println("Coroutines!")
    }
    println("Hello,")
    delay(2000L)
}

/*
output:
    Your profit is 25000
    Your profit is 25000
    Completed in 2013 ms vs 1025 ms
*/