package com.dicoding.kotlin.coroutines.no5

import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// MATERI: coroutine dispactcher (dispatcher: pengirim)
/*  menentukan thread tempat berjalannya coroutine
*   menggunakan base class CoroutineDispacther utk
*   menggunakan beberapa objek untuk menentukan thread
*   yang menjalankan coroutine */

/* Dispatcher.Default */
/*  dispatcher default yang digunakan oleh semua stndard builders
*   launch, async, dll -> jika dipatcher tidak ditentukan maka
*   otomatis menggunakan deispatcher.default, DD menggunakan
*   kumpulan thread yg ada pada JVM, jumlah maksimal thread sama
*   dengan jumlah core dari CPU */

/* implisit */
fun main1() = runBlocking {
    launch {
        // TODO: Implement suspending lambda here
    }
}

/* eksplisit */
fun main2() = runBlocking {
    launch(Dispatchers.Default){
        // TODO: Implement suspending lambda here
    }
}

/* Dispatcher.IO */
/*  Sebuah dispatcher yang dapat digunakan untuk membongkar pemblokiran operasi I/O.
    Ia akan menggunakan kumpulan thread yang dibuat berdasarkan permintaan. */
fun main3() = runBlocking {
    launch(Dispatchers.IO){
        // TODO: Implement algorithm here
    }
}

/* Dispatcher.Unconfined */
fun main4() = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}
/*
Output:
    Starting in main
    Resuming in kotlinx.coroutines.DefaultExecutor
Penjelasan:
    Artinya, coroutine telah dimulai dari main thread,
    kemudian tertunda oleh fungsi delay selama 1 detik.
    Setelah itu, coroutine dilanjutkan kembali
    pada thread DefaultExecutor.
*/


///* Builder untuk menentukan thread yg dibutuhkan */

/* Single Thread Context */
fun main5() = runBlocking<Unit> {
    val dispatcher = newSingleThreadContext("myThread")
    launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}
/*
Output:
    Starting in myThread
    Resuming in myThread
*/

/* Thread Pool */
fun main6() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(3, "myPool")

    launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}
/*
Output:
    Starting in myPool-1
    Resuming in myPool-2
Penjelasan
    Pada kode di atas, kita telah menetapkan thread myPool
    sebanyak 3 thread. Runtime akan secara otomatis menentukan
    pada thread mana coroutine akan dijalankan dan dilanjutkan
*/
