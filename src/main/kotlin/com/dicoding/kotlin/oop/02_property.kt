package com.dicoding.kotlin.oop

// MATERI: property + property accessor (getter, setter)
/*  var -> property mutable
            - menghasilkan getter dan setter
*   val -> property read-only
*           - hanya ada getter
    fungsi getter setter juga bisa dibuat manual (di-override) */

class Animal2 {
    var name: String = "Dicoding Miaw"
        get() {
            println("Fungsi Getter terpanggil")
            return field
        }
        set(value) {
            println("Fungsi Setter terpanggil")
            field = value
        }
    /*  urutan getter setter tdk penting
    *   bisa mendefinisikan salah satu */
}

fun main() {
    val dicodingCat = Animal2()

    println("Nama: ${dicodingCat.name}")
    dicodingCat.name = "Goose"
    println("Nama: ${dicodingCat.name}")
}

/*
Output:
Fungsi Getter terpanggil
Nama: Dicoding Miaw

Fungsi Setter terpanggil

Fungsi Getter terpanggil
Nama: Goose
*/
