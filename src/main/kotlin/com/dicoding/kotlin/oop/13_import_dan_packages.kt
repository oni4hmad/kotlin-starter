package com.dicoding.kotlin.oop

// MATERI: import dan packages

/*
import packagename.ClassName
import packagename.functionName
import packagename.propertyName
*/

import kotlin.random.Random
import kotlin.math.PI
import kotlin.math.cos as cosinus
import kotlin.math.sqrt as akar

/* atau import semua */

import kotlin.math.*

fun main(){
    /* val someInt = kotlin.random.Random(0).nextInt(1, 10) */
    val someInt = Random(0).nextInt(1, 10)

    println(PI)
    println(cosinus(120.0))
    println(akar(9.0))
}