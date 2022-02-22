package com.dicoding.kotlin.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

// MATERI: channels

fun main() = runBlocking(CoroutineName("main")) {
    val channel = Channel<Int>()
    launch(CoroutineName("v1coroutine")) {
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) channel.send(x * x)
    }

    repeat(5) { println(channel.receive()) }
    println("received in ${Thread.currentThread().name}")
}
/*
Output:
    Sending from main @v1coroutine#2
    1
    4
    9
    16
    25
    received in main @main#1
*/
