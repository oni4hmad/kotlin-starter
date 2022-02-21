package com.dicoding.kotlin.oop

import kotlin.reflect.KProperty

// MATERI: property delegation
/* tidak perlu mendefinisikan getter setter untuk setiap class
   dengan property yang sama sehingga mempersingkat code */

class DelegateName {
    private var value: String = "Default"

    operator  fun getValue(classRef: Any?, property: KProperty<*>): String {
        println("Fungsi ini sama seperti getter untuk propert ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, newValue: String) {
        println("Fungsi ini sama seperti setter untuk properti ${property.name} pada class $classRef")
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

/* mendelegaasikan class property (dgn keyword by) */
class Animal3 {
    var name: String by DelegateName()
    /*  sehingga nilai property name dikelola melalui kelas DelegateName
    *   bisa mendelegasikan class di banyak property pada banyak kelas */
}

class Person {
    var name: String by DelegateName()
}

class Hero {
    var name: String by DelegateName()
}

/* ------------------------------------------ */

fun main() {
    cobaObjectString()
    cobaObjectGeneric()
}

/* ------------------------------------------ */

/* coba buat object (property String) */
fun cobaObjectString() {
    val animal = Animal3()
    animal.name = "Dicoding Miaw"
    println("Nama Hewan: ${animal.name}")

    val person = Person()
    person.name = "Dimas"
    println("Nama Orang: ${person.name}")

    val hero = Hero()
    hero.name = "Gatotkaca"
    println("Nama Pahlawan: ${hero.name}")
}
/*
output:
    Fungsi ini sama seperti setter untuk properti name pada class Animal3@17f052a3
    Nilai name dari: Default akan berubah menjadi Dicoding Miaw
    Fungsi ini sama seperti getter untuk properti name pada class Animal3@17f052a3
    Nama Hewan: Dicoding Miaw

    Fungsi ini sama seperti setter untuk properti name pada class Person@2e0fa5d3
    Nilai name dari: Default akan berubah menjadi Dimas
    Fungsi ini sama seperti getter untuk properti name pada class Person@2e0fa5d3
    Nama Orang: Dimas

    Fungsi ini sama seperti setter untuk properti name pada class Hero@5010be6
    Nilai name dari: Default akan berubah menjadi Gatotkaca
    Fungsi ini sama seperti getter untuk properti name pada class Hero@5010be6
    Nama Pahlawan: Gatotkaca
*/

/* coba buat delegate property generic (Any) */
class DelegateGenericClass {
    private var value: Any = "Default"

    operator fun getValue(classRef: Any?, property: KProperty<*>): Any {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any, property: KProperty<*>, newValue: Any) {
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class Animal4 {
    var name: Any by DelegateGenericClass()
    var weight: Any by DelegateGenericClass()
    var age: Any by DelegateGenericClass()
}

/* coba buat object class property generic/Any (class Animal) */
fun cobaObjectGeneric() {
    val animal = Animal4()
    animal.name = "Dicoding cat"
    animal.weight = 6.2
    animal.age = 1

    println("Nama: ${animal.name}")
    println("Berat: ${animal.weight}")
    println("Umur: ${animal.age} Tahun")
}
/*
output:
    Nilai name dari: Default akan berubah menjadi Dicoding cat
    Nilai weight dari: Default akan berubah menjadi 6.2
    Nilai age dari: Default akan berubah menjadi 1
    Fungsi ini sama seperti getter untuk properti name pada class Animal4@17f052a3
    Nama: Dicoding cat

    Fungsi ini sama seperti getter untuk properti weight pada class Animal4@17f052a3
    Berat: 6.2

    Fungsi ini sama seperti getter untuk properti age pada class Animal4@17f052a3
    Umur: 1 Tahun
*/