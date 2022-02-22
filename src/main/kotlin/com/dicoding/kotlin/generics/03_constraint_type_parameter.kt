package com.dicoding.kotlin.generics

// MATERI: constraint type parameter (:)
/* membatasi tipe apa saja yang dapat digunakan
*   sebagai parameter */

/* pada class */

class ListNumber<T : Number>: List<T>{
    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }
}

/* pada function */

fun <T : Number> kotlin.collections.List<T>.sumNumber(): T {
    TODO("Not yet implemented")
}

fun main() {
    val numbers = ListNumber<Long>()
    val numbers2 = ListNumber<Int>()
    // val numbers3 = ListNumber<String>() // error : Type argument is not within its bounds

    val numbers4 = listOf(1, 2, 3, 4, 5)
    numbers4.sumNumber()
    val names = listOf("dicoding", "academy")
    // names.sumNumber() // error : inferred type String is not a subtype of Number
}
