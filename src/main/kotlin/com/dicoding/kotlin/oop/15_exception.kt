package com.dicoding.kotlin.oop

// MATERI: exception
/*  event (kejadian) yang dapat mengacaukan jalannya suatu program.
    Pada Kotlin semua exception bersifat Unchecked,
    yang artinya exception terjadi karena kesalahan pada kode kita.
        Contoh (seringnya):
        ArithmeticException
        NumberFormatException
        NullPointerException */

/* ArithmeticException
*   exception yang terjadi karena kita membagi
*   suatu bilangan dengan nilai nol */

fun ae() {
    val someValue = 6
    println(someValue / 0)
}
/*
output:
    Exception in thread "main" java.lang.ArithmeticException: / by zero
*/

/* NumberFormatException
*   kesalahan dalam format angka */

fun nfe() {
    val someStringValue = "18.0"
    println(someStringValue.toInt())
}
/*
output:
    Exception in thread "main" java.lang.NumberFormatException: For input string: "18.0"
*/

/* NullPointerException
*   NPE terjadi karena sebuah variabel atau objek memiliki nilai null,
*   padahal seharusnya objek atau variabel tersebut tidak boleh null */
fun npe() {
    val someNullValue: String? = null
    val someMustNotNullValue: String = someNullValue!!
    println(someMustNotNullValue)
}
/*
output:
    Exception in thread "main" kotlin.NullPointerException at MainKt.main(Main.kt:3)
*/