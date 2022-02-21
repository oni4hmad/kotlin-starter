package com.dicoding.kotlin.oop

// MATERI: exception handling
/*  try-catch, try-catch-finally, dan multiple catch */

fun main() {
    contohTryCatch()
    contohTryCatchFinally()
    contohMultipleCatch()
}

/* try-catch */

fun contohTryCatch() {
    val someNullValue: String? = null
    lateinit var someMustNotNullValue: String

    try {
        // Block try, menyimpan kode yang membangkitkan exception
        someMustNotNullValue = someNullValue!!
        println(someMustNotNullValue)
    } catch (e: Exception) {
        // Block catch akan terpanggil ketika exception bangkit.
        someMustNotNullValue = "Nilai String Null"
        println(someMustNotNullValue)
    }
}
/*
output:
    Nilai String Null
*/

/* try-catch-finally */

fun contohTryCatchFinally() {
    val someNullValue: String? = null
    lateinit var someMustNotNullValue: String

    try {
        someMustNotNullValue = someNullValue!!
    } catch (e: Exception) {
        someMustNotNullValue = "Nilai String Null"
    } finally {
        println(someMustNotNullValue)
    }
}
/*
output:
    Nilai String Null
*/

/* multiple catch */

fun contohMultipleCatch() {

    val someStringValue: String? = null
    /* yang akan terjadi adalah NullPointerException */
    // val someStringValue: String? = "12.0"
    /* yang akan terjadi adalah NumberFormatException */
    var someIntValue: Int = 0

    try {
        // Block try, menyimpan kode yang membangkitkan exception
        someIntValue = someStringValue!!.toInt()
    } catch (e: NullPointerException) {
        // Block catch akan terpanggil ketika terjadi NullPointerException.
        someIntValue = 0
    } catch (e: NumberFormatException) {
        // Block catch akan terpanggil ketika terjadi NumberFormatException.
        someIntValue = -1
    } catch (e: Exception) {
        // Block catch akan terpanggil ketika terjadi Exception selain keduanya.
        println(e.toString())
    }
    finally {
        // Block finally akan terpanggil setelah keluar dari block try atau catch
        when(someIntValue){
            0 -> println("Catch block NullPointerException terpanggil !")
            -1 -> println("Catch block NumberFormatException terpanggil !")
            else -> println(someIntValue)
        }
    }
}