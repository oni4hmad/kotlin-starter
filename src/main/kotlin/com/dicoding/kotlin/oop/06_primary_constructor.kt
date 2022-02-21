package com.dicoding.kotlin.oop

// MATERI: primary constructor (+init block)

class Animal6(
    name: String,
    weight: Double,
    age: Int = 0, // dg default value
    isMammal: Boolean = true
    ) {

    /* deklarasi kembali property utk init block */
    val name: String
    val weight: Double
    val age: Int
    val isMammal: Boolean

    /*  init block: untuk validasi property,
        dijalankan ketika objek diinstansiasi */
    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0 else age
        this.name = name
        this.isMammal = isMammal
    }
}

fun main() {
    val dicodingCat = Animal6("Dicoding Miaw", 4.2, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")
}
/*
output:
    Nama: Dicoding Miaw, Berat: 4.2, Umur: 2, mamalia: true
*/