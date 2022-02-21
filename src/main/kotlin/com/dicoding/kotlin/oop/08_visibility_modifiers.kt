package com.dicoding.kotlin.oop

// MATERI: visibility modifiers
/*  public (default), private, protected, internal
*   bisa digunakan utk kelas, objek, dan lainnya */

/*  public,
*   co: property bisa diakses ketika menggunakan objek tsb */

/*  contoh private
*   hanya bisa diakses di class tersebut */

class Animal8(
    private var name: String,
    private val wegith: Double,
    private val age: Int,
    private val isMammal: Boolean = true
    ) {

    /*  fungsi getter setter ditambahkan manual
    *   karena property private */

    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }

}

/*  contoh protected
*   hanya bisa diakses di child class */

open class Animal9(val name: String, protected val weight: Double)

class Cat(pName: String, pWeight: Double) : Animal9(pName, pWeight)

/*  contoh internal
*   hanya bisa diakses di modul (.jar) yang sama */

internal class Animal10(val name: String)

fun main() {
    val dicodingCat = Animal8("Dicoding Miaw", 2.5, 2)
    // println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")
    /* Cannot access '[PROPERTY]': it is private in 'Animal8' */

    /* setter getter property private */
    println(dicodingCat.getName())
    dicodingCat.setName("Gooose")
    println(dicodingCat.getName())

    /* property protected tdk bisa diakses */
    /*  weight tdk bisa diakses karena parent class (Animal9)
    *   mendefinisikannya dengan visibility protected */
    val cat = Cat("Dicoding Miaw", 2.0)
    println("Nama Kucing: ${cat.name}")
    // println("Berat Kucing: ${cat.weight}")
    /* Cannot access 'weight': it is protected in 'Cat' */
}

/*
output:
    Dicoding Miaw
    Gooose
*/