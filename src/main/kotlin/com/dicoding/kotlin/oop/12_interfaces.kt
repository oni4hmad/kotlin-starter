package com.dicoding.kotlin.oop

// MATERI: interfaces
/*  Kelas yang mengimplementasikan sebuah interface
    diharuskan melakukan override seluruh properti
    dan fungsi sekaligus mendefinisikan isi fungsi */

/* best practice: dimulai dgn I utk menandakan interface */
interface IFly {
    /* fungsi tanpa body */
    fun fly()
    /* property tanpa inisialisasi nilai */
    val numberOfWings: Int
}

class Bird(override val numberOfWings: Int) : IFly {
    override fun fly() {
        if(numberOfWings > 0) println("Flying with $numberOfWings wings")
        else println("I'm Flying without wings")
    }
}