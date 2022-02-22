package com.dicoding.kotlin.generics

// MATERI: mendeklarasikan kelas generics
/*  menerapkannya dengan meletakkan
    tipe parameter ke dalam angle brackets (<>) */

interface List<T>{
    operator fun get(index: Int): T
}

fun main() {
    val squad = listOf<String>("Oni", "Fio", "Fajar", "Cahya")
    val comparedByNames = Comparator {a: String, b: String ->
        a.first().toInt() - b.first().toInt()
    }
    squad.sortedWith(comparedByNames).forEach(::println)
}