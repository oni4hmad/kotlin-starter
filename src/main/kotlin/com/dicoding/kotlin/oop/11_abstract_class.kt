package com.dicoding.kotlin.oop

// MATERI: abstract class
/*  gambaran umum dari class, untuk tdk bisa direalisasikan jd objek
*   melainkan diturunkan sifatnya pada child class */

abstract class Animal13(var name: String, var weight: Double, var age: Int, var isCarnivore: Boolean){

    open fun eat(){
        println("$name sedang makan !")
    }

    open fun sleep(){
        println("$name sedang tidur !")
    }
}

/* child class */
class Cat3(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean, val furColor: String, val numberOfFeet: Int)
    : Animal13(pName, pWeight, pAge, pIsCarnivore) {

    fun playWithHuman() {
        println("$name bermain bersama Manusia!")
    }

    override fun eat() {
        println("$name sedang makan ikan!")
    }

    override fun sleep() {
        println("$name sedang tidur di bantal!")
    }

}

fun main() {
    // val animal = Animal13("dicoding animal", 2.6, 1, true)
    /* Cannot create an instance of an abstract class */
}