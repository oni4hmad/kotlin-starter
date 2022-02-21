package com.dicoding.kotlin.oop

class `00_object_everywhere` {
}

fun main() {
    val someString = "123"
    val someInt = someString.toInt()
    val someOtherString = "12.34"
    val someDouble = someOtherString.toDouble()

    println(someInt is Int)
    println(someDouble is Double)
}

/*
Output:
true
true
*/

/*
Class:  Merupakan sebuah blueprint yang terdapat properti
        dan fungsi di dalamnya
Properties: Karakteristik dari sebuah kelas, memiliki tipe data.
Functions: Kemampuan atau aksi dari sebuah kelas.
*/