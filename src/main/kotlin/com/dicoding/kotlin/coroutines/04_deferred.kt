package com.dicoding.kotlin.coroutines.no4

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// MATERI: deferred
/*  nilai deferred -> hasil berupa nilai atau exception
*   untuk fungsi async()
*   ketika state completed, nilai bisa diakses dgn await()
*   jika terjadi exception, akses dg getCompletionExceptionOrNull
*   async bisa diisi param (start = CoroutineStart.Lazy)
*       bisa pake start(), join(), dan await() */

/* misal, mempunyai 2 suspending funciton */
suspend fun getCapital(): Int {
    delay(1000L)
    return 50000
}

suspend fun getIncome(): Int {
    delay(1000L)
    return 75000
}

fun main() = runBlocking {
    val capital = async (start = CoroutineStart.LAZY) { getCapital() }
    val income = async (start = CoroutineStart.LAZY) { getIncome() }
    income.join()
    capital.join() // kalau cmn salah satu dijoin maka error too long
    println("Your profit is ${income.getCompleted() - capital.await()}")
}