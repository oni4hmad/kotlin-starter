package com.dicoding.kotlin.oop

class `01_membuat_class` {
}

// MATERI: membuat class

class Animal(
    /* primary constructor */
    val name: String, // attribute or property
    val weight: Double,
    val age: Int,
    val isMamal: Boolean
) {
    /* behaviour or function */
    fun eat() {
        println("$name makan!")
    }

    fun sleep() {
        println("$name tidur!")
    }
}

fun main() {
    // membuat objek dari kelas Animal (instansiasi)
    val dicodingCat = Animal("Dicoding Miaw", 4.2, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, Mamalia: ${dicodingCat.isMamal}")
    dicodingCat.eat()
    dicodingCat.sleep()
    /*
    Output:
    Nama: Dicoding Miaw, Berat: 4.2, Umur: 2, mamalia: true
    Dicoding Miaw makan!
    Dicoding Miaw tidur!
    */
}