package com.dicoding.kotlin.generics.variance

// MATERI: variance
/* covariance (out), contravariance (in) */

abstract class Vehicle(wheel: Int)
class Car(speed: Int) : Vehicle(4)
class MotorCycle(speed: Int) : Vehicle(2)

/* contoh covariant (out)
*   type parameter hanya boleh menjadi diolah/dijadikan return value
*   tidak boleh dipassingkan menjadi param di fungsi */
interface List2<out E> : Collection<E> {
    operator fun get(index: Int): E
}

/* contoh contravariance (in)
*   type parameter hanya boleh menjadi dikonsumsi/dijadikan param
*   tidak boleh jadi return value di fungsi */
interface Comparable2<in T> {
    operator fun compareTo(other: T): Int
}

fun main() {
    val carList = listOf(Car(100) , Car(120))
    val vehicleList: List<Vehicle> = carList
    /* variance: covariance | E out */
}