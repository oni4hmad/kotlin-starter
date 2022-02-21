package com.dicoding.kotlin

// contoh class
class User(val name : String, val age : Int) {
    override fun toString(): String {
        return "User(name=$name,age=$age)"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }
    fun testPrint(other: Any?) {
        println("this -> $this")
        println("other -> $other")
        println(this === other)
        println(this == other)
        println(javaClass)
        println(other?.javaClass)
    }
}

// contoh data class
data class DataUser(val name : String, val age : Int) {
    fun intro() {
        println("My name is $name, i'm $age years old")
    }
}

fun main() {
    val user = User("oni", 21)
    val dataUser = DataUser("oni", 21)

    println(user) // com.dicoding.kotlin.User@7ba4f24f (no overriden toString)
    println(dataUser)

    // equals on DataUser
    val _dataUser = DataUser("oni", 21)
    val _dataUser2 = DataUser("oni", 21)
    val _dataUser3 = DataUser("fio", 66)

    println(_dataUser.equals(_dataUser2)) // true
    println(_dataUser2.equals(_dataUser3)) // false

    // equals on User
    val _user = User("oni", 21)
    val _user2 = User("oni", 21)
    val _user3 = User("fio", 66)

    println(_user.equals(_user2)) // false -after-overidden-> true
    println(_user2.equals(_user3)) // false
    println(_user.hashCode())
    println(_user.testPrint(_user2))

    // copy data class
    val _dataUser4 = _dataUser.copy()
    println(_dataUser4)
    // copy dan ganti salah satu nilai properti
    val _dataUser5 = _dataUser.copy(age = 18)
    println(_dataUser5)

    // MATERI: destructing declaration (componentN)
    val _dataUser6 = DataUser("oni", 21)
    val name = _dataUser6.component1()
    val age = _dataUser6.component2()
    println("My name is $name, i'm $age years old")

    // behaviour (method) di dalam data class
    _dataUser6.intro()

    // MATERI: collections (list, set, map)

    // list (immutable)
    val numberList : List<Int> = listOf(1, 2, 3)
    println(numberList)
    val anyList : List<Any> = listOf('a', "Kotlin", 3, true)
    println(anyList)
    println(anyList[3])

    // list (mutable)
    val _anyList = mutableListOf('a', "Kotlin", 3, true, User("fio", 77))
    println(_anyList)
    _anyList.add('d')
    _anyList.add(1, "love")
    _anyList[3] = false
    println(_anyList)
    _anyList.removeAt(1)
    println(_anyList)

    // set (tidak ada diplikasi, urutan tidak penting)
    val integerSet = setOf(1, 2, 4, 2, 1, 5)
    println(integerSet) // Output: [1, 2, 4, 5]

    // set: perbandingan set dengan nilai unik sama urutan beda
    val setA = setOf(1, 2, 4, 2, 1, 5)
    val setB = setOf(1, 2, 4, 5)
    println(setA == setB) // Output: true

    // set: cek nilai dalam set
    println(5 in setA) // Output: true

    // set: union (gabung) dan intersect (irisan)
    val setC = setOf(1, 5, 7)
    val setUnion = setA.union(setC)
    val setIntersect = setA.intersect(setC)
    println(setUnion) // Output: [1, 2, 4, 5, 7]
    println(setIntersect) // Output: [1, 5]

    // set: mutableSet (tidak bisa ubah nilai, kalau hapus by nilai bkn index)
    val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
    /// mutableSet[2] = 6 // tidak bisa mengubah set immutable
    mutableSet.add(6) // menambah item di akhir set
    mutableSet.remove(1) //menghapus item yang memiliki nilai 1

    // map (hasmap: key-value)
    val capital = mapOf(
        // [key] to [value]
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    )
    println(capital["Jakarta"]) // Output: Indonesia
    println(capital.getValue("Jakarta")) // Output: Indonesia (unsafe)
    println(capital["Amsterdam"]) // Output: null (jika getValue -> muncul exception)
    println(capital.keys) // Output: [Jakarta, London, New Delhi]
    println(capital.values) // Output: [Indonesia, England, India]

    // map: mutable map
    val mutableCapital = capital.toMutableMap()
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")
    println(mutableCapital)
    /// mutable collection TIDAK DISARANKAN : susah ditrack apabila ada perubahan

    // MATERI: collections operations

    // filter() -> return nilai yang sesuai kondisi
    val numList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numList.filter {it % 2 == 0}
    println(evenList) // Output: [2, 4, 6, 8, 10]

    // filterNot() -> return nilai yang tdk sesuai kondisi
    val notEvenList = numList.filterNot {it % 2 == 0}
    println(notEvenList) // Output: [1, 3, 5, 7, 9]

    // map() -> return nilai diberi suatu expression
    val multipleBy5 = numList.map {it * 5}
    println(multipleBy5) // Output: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]

    // count() -> return jumlah item di collection
    println(numList.count()) // Output: 10
    println(numList.count {it % 3 == 0}) // Output: 3 (jumlah item yg habis dibagi 3)

    /*  find() -> return satu nilai pertama sesuai kondisi
        firstOrNull() -> mirip find()
        lastOrNull() -> mirip firstOrNull() tp utk nilai terakhir
    */
    val firstOddNumber = numList.find {it % 2 == 1}
    println(firstOddNumber) // Output: 1
    val firstOrNullNumber = numList.firstOrNull {it % 2 == 3}
    println(firstOrNullNumber) // Output: null
    val lastOddNumber = numList.lastOrNull {it % 2 == 1}
    println(lastOddNumber) // Output: 9

    /* first() -> mirip firstOrNull() tp unsafe/exception jika tdk ada
    *  last() -> mirip lastOrNull() tp unsafe
    */
    /// val moreThan10 = numList.first {it > 10} // Output: Exception!

    // sum() -> menjumlah
    val sumOfList = numList.sum()
    println(sumOfList) // Output: 55

    // sorted() -> sort ascending (descending: sortedDescending())
    val kotlinChar = listOf('k', 'o', 't', 'l', 'i', 'n')
    val ascendingSort = kotlinChar.sorted()
    println(ascendingSort) // Output: [i, k, l, n, o, t]
    val descendingSort = kotlinChar.sortedDescending()
    println(descendingSort) // Output: [t, o, n, l, k, i]

    // MATERI: sequences (lazy evaluation)

    // perbedaan eager dengan lazy
    fun eagerVsLazy() {
        // eager evaluation
        val list = (1..1000000).toList()
        list.filter {it % 5 == 0}.map {it * 2}. forEach { println(it) }
        /*  list diatas akan mengevaluasi 1jt value/semuanya pada filter lalu lanjut ke map trus println
            jadi akan berlansung lama */

        // lazy evaluation (dgn asSequence())
        list.asSequence().filter {it % 5 == 0}.map {it * 2}. forEach { println(it) }
        /*  sedangkan pada lazy, value akan dievaluasi satu persatu (filter > map > print)
        *   tidak menunggu semua 1jt value selesai dulu di satu evaluasi (filter/map/forEach) */
    }

    // membuat sequence
    val sequenceNum = generateSequence(1) { it + 1 }
    /*  (1) -> item pertama
    *   it + 1 -> lambda exp. penambahan item sebelumnya +1
    *   membuat collection seq. tak terbatas
    *   sehingga dibutuhkan .take(n), untuk membuat n item*/
    sequenceNum.take(5).forEach { println("-s: $it") } // Output: 1 2 3 4 5
}
