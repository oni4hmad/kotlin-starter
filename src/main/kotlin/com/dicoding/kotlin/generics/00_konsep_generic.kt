package com.dicoding.kotlin.generics

// MATERI: konsep generics
/* konsep yang memungkinkan suatu kelas atau interface
    menjadi tipe parameter yang dapat digunakan untuk
    berbagai macam tipe data. */

fun main() {
    /* generics pada list */
    val contributor = listOf<String>("jasoet", "alfian", "nrohmen", "dimas", "widy")
    /* fungsi listOf menggunakan tipe parameter String
    *   maka nilai argument/parameter yg bisa kita masukan adalah string
    *   tipe param bisa disederhanakan kompiler akan menerapkan scr otomatis*/
    val contributor2 = listOf("jasoet", "alfian", "nrohmen", "dimas", "widy")

    /* deklarasi lebih dari satu tipe parameter
    *   pada map sebagai key dan value */
    val points = mapOf<String, Int>("alfian" to 10, "dimas" to 20)
}