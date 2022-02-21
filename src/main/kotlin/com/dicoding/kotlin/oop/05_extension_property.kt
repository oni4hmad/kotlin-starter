package com.dicoding.kotlin.oop

// MATERI: extension property
/* membuat property baru tanpa membuat class yang mewarisi class tsb
   tetapi property yang dibuat tdk benar2 berada pada class */

class Animal5(
    var name: String,
    var weight: Double,
    var age: Int,
    var isMamal: Boolean
)

val Animal.getAnimalInfo: String
    get() = "Nama ${this.name}, Berat: ${this.weight}, Umur: ${this.age}, Mamalia: ${this.isMamal}"

/* menggunakan pada objek Animal */

fun main() {
    val dicodingCat = Animal("Dicoding Miaw", 5.0, 2, true)
    println(dicodingCat.getAnimalInfo)
}
/*
* Output:
* Nama: Dicoding Miaw, Berat: 5.0, Umur: 2 Mammalia: true
*/