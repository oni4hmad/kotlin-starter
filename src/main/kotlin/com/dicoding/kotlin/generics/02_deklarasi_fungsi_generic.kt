package com.dicoding.kotlin.generics

// MATERI: deklarasi fungsi generic

/* tipe parameter ditempatkan sebelum nama fungsi */

/* contoh fungsi generic (pada extensions function) */

public fun <T> List<T>.slice(indices: Iterable<Int>): List<T> {
    /*...*/
    return this
}

fun main() {
    val numbers = (1..100).toList()
    println(numbers.slice<Int>(1..10)) // unimplemented
}
/*
   output : [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
*/