package com.dicoding.kotlin.coroutines.no2

import kotlinx.coroutines.*

// MATERI: membuat dan menjalankan job

/* Inisialisasi dpt dg Job() atau launch() */

/* menggunakan launch() */
fun main1() = runBlocking {
    val job = launch {
        // Do background task here
    } // New -> lgsg dijalankan
}

/* menggunakan Job() */
fun main2() = runBlocking {
    val job = Job() // New -> lgsg dijalankan
}

/* agar tdk langsung dijalankan
*   gunakan CoroutineStart.LAZY*/
fun main3() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        TODO("Not implemented yet!")
    }
}

/* Menjalankan Job
*   menggunakan start() */
fun main4() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Start new job!")
    }

    job.start()
    println("Other task")
}
/*
Output:
    Other task
    Start new job!
*/

/* menggunakan join() */
fun main5() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Start new job!")
    }

    job.join()
    println("Other task")
}
/*
Output:
    Start new job!
    Other task
*/

/*
Perbedaan:
    start() -> memulai tanpa menunggu selesai
    join() -> menunda eksekusi (selanjutnya) sampai job selesai
Setelah dimulai, job state -> Active
*/