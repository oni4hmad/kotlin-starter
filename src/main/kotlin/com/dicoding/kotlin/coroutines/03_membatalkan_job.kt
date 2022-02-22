package com.dicoding.kotlin.coroutines.no3

import kotlinx.coroutines.*

// MATERI: membatalkan job
/*  menggunakan cancel()
    active job -> calcel() -> cancelling -> cancelled
    unactive/new job -> calcel() -> cancelled
    * cancelled == completed
*/

@InternalCoroutinesApi
fun main() = runBlocking {
    val job = launch {
        delay(5000)
        println("Start new job!")
    }

    delay(2000)
    /* cancel dg cause */
    job.cancel(cause = CancellationException("time is up!"))
    println("Cancelling job...")
    if (job.isCancelled) {
        println("Job is cancelled because ${job.getCancellationException().message}")
    }
}
/*
Output:
    Cancelling job...
    Job is cancelled because time is up!
*/
