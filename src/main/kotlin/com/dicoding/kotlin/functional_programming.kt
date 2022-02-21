package com.dicoding.kotlin

class functional_programming {
}

fun main() {
    // MATERI: konsep functional
    // nonFuncVsFunc()

    // MATERI: Anatomi Function
    namaFunction(1, 2)

    // MATERI: named and default argument
    namedDefaultArg()

    // MATERI: vararg (variable argument)
    varArgument()

    // MATERI: extensions (function/property)
    extensionsFuncProp()

    // MATERI: nullable receiver
    nullableReceiver()

    // MATERI: function type
    funcType()

    // MATERI: lambda
    lambdaExp()

    // MATERI: high-order function
    highOrderFunc()

    // MATERI: lambda with receiver
    lambdaWithReceiver()

    // MATERI: kotlin standard library
    /* scope function, context object */
    kotlinStd()
    /* run, with, apply */
    runWithApply()

    // MATERI: function dan propery reference
    funcPropReference()

    // MATERI: function inside function
    /* fungsi dalam fungsi, untuk menghindari code duplication */

    // MATERI: advance collection function

    // MATERI: fold, drop, and take
    foldDropTake()

    // MATERI: slice, distinct, chuncked
    sliceDistinctChuncked()

    // MATERI: recursion - tail call recursion
    recursion()
}

fun nonFuncVsFunc() {
    // non-functional
    /*val list = getListUser()
    fun getUsername(): List<String> {
        val name = mutableListOf<String>()
        for (user in list) {
            name.add(user.name)
        }
        return name
    }*/

    // functional
    /*fun getUsername2(): List<String> {
        return list.map {
            it.name
        }
    }*/
}

// contoh: function header, body, paramater,
// visibility modifier, return type
private fun namaFunction(valueA: Int, valueB: Int): Int {
    // another magic
    return valueA + valueB
}

fun namedDefaultArg() {
    // named argument
    fun getFullName(first: String, middle: String, last: String): String {
        return "$first $middle $last"
    }
    /// function call
    val fullName = getFullName(middle = " is ", first = "Kotlin", last = "Awesome")
    println(fullName) // Output: Kotlin is Awesome

    // default argument
    fun _getFullName(
        first: String = "Kotlin ",
        middle: String = " is ",
        last: String = "Awesome"): String {
        return "$first $middle $last"
    }
    /// function call
    val _fullName = _getFullName(first = "Dicoding")
    println(_fullName) // Output: Dicoding is Awesome
}

fun varArgument() {
    // contoh vararg
    fun sumNumbers(vararg number: Int): Int {
        return number.sum()
    }
    val num = sumNumbers(10, 20, 30 ,40)
    println(num) // Output: 100

    // vararg dengan generic
    /* bisa untuk tipe data apa saja */
    fun <T> asList(vararg input: T): List<T> {
        val result = ArrayList<T>()
        for (item in input) {
            result.add(item)
        }
        return result
    }

    // vararg adalah Array (bisa menggunakan fungsi/properti Array)
    fun getNumberSize(vararg number: Int): Int {
        return number.size
    }
    val _num = getNumberSize(10, 20, 30, 40, 50)
    println(_num) // Output: 5

    // aturan vararg arguments
    /// vararg tidak boleh >1
    // fun sumNumbers(vararg number: Int, vararg numbers)
    // Kotlin: Multiple vararg-parameters are prohibited
    /// jika param vararg di akhir
    fun sets(name: String, vararg number: Int): Int {
        // ...
        return 0
    }
    //// function call
    sets("Kotlin", 10, 10)
    /// jika param vararg di awal
    fun sets(vararg number: Int, name: String): Int {
        // ...
        return 0
    }
    //// function call: dg named argument
    sets(10, 10, name = "Kotlin")

    // spread operator (*) untuk Array pada vararg
    fun __sets(vararg number: Int): Int {
        return number.sum()
    }
    val __number: IntArray = intArrayOf(10, 20, 30, 40, 50)
    println(__sets(1, 2, 3, *__number, 4)) // Output: 160
}

// Extensions Property
val Int.slice: Int
    get() = this / 2

fun extensionsFuncProp() {
    // tanpa extension (inheritance)
    /*class NewInt : Int() {
        fun printInt() {
            println("value %this")
        }
    }*/

    // Extensions Functions
    fun Int.printInt() {
        println("value $this")
    }
    fun Int.plustThree(): Int {
        return this + 3
    }
    // function call
    10.printInt() // Output: value 10
    10.plustThree().printInt() // Output: value 13

    // property call (ext. property)
    println(10.slice) // Output: 5
}

// Nullable Receiver

// Contoh nullable receiver dg elvis opt
val Int?.slice: Int
    get() = this?.div(2) ?: 0
val Int.sliceX: Int
    get() = this.div(2)

fun nullableReceiver() {
    // null receiver obj. property call
    val value: Int? = null
    println(value.slice) // Output: 0

    // nullable receiver type property call
    val value1: Int? = null
    println(value?.sliceX) // Output: null
}

// Function Type

// Menyimpan function type di typealias
/* untuk function type yang panjang */
typealias Arithmetic = (Int, Int) -> Int
/* bisa nullable juga */
typealias Arithmetic1 = ((Int, Int) -> Int)?
fun funcType() {
    /*
    *   Contoh function type
    *   (Int, Int) -> String
    *       function memiliki dua param Int
    *       dengan return type String
    *   kalau tdk ada return wajib pake Unit
    *   (Int, Int) -> Unit
    */

    // Menggunakan typealias
    val sum: Arithmetic = { valueA, valueB -> valueA + valueB }
    val multiply: Arithmetic = { valueA, valueB -> valueA * valueB }
    val sum1: Arithmetic1 = { valueA, valueB -> valueA * valueB }
    // contoh val call utk nullable typealias
    println(sum1?.invoke(10, 20)) // Output: 30
}

fun lambdaExp() {
    // Contoh lambda
    val message = { println("Hello from lambda") }
    message() // Output: Hellow from lambda

    // Lambda dg parameter
    val printMessage = { message: String -> println(message) }
    printMessage("Hello from Lambda") // Output: Hello from lambda

    // Lambda dg return value
    /* return value ada baris terakhir pada body function */
    val messageLength = { message: String -> message.length }
    val length = messageLength("Hello from Lambda")
    println("Message length $length") // Output: Message length 17
}

fun highOrderFunc() {
    // Contoh high order function
    var _sum: (Int) -> Int = { value -> value + value }
    fun printResult(value: Int, sum: (Int) -> Int) {
        val result = sum(value)
        println(result)
    }
    /* function call */
    printResult(10, _sum) // Output: 20
    /* .. atau */
    printResult(10) { value -> value + value } // Output: 20
    /*  lambda exp. bisa ditaruh di luar parethesis */
}

fun lambdaWithReceiver() {
    // contoh lambda with receiver pada function
    fun buildString(action: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        /* mempassing objek stringBuilder as reference
        *  untuk dipakai jd objek receiver di lambda action */
        stringBuilder.action()
        return stringBuilder.toString()
    }
    /* function call */
    val message = buildString {
        // this bisa dihilangkan
        append("Hello ")
        append("from ")
        append("lambda ")
    }
    println(message) // Output: Hello from lambda
}

fun kotlinStd() {
    // Scope Function
    /* fungsi yang digunakan utk akses konteks dari sebuah objek */
    /* contohnya: let, run, with, apply, dan also */

    // (cara akses) Context Object:
    /* lambda receiver (this) -> run, with, apply */
    val buildString = StringBuilder().apply {
        append("Hello ")
        append("Kotlin")
    }
    println(buildString) // Output: Hello Kotlin

    /* lambda argument (it) -> let, also */
    val text = "Hello"
    text.let {
        val message = "$it Kotlin"
        println(message) // Output: Hello Kotlin
    }
}

fun runWithApply() {
    // run (this)
    /*  berguna jika di dalam blok lambda terdapat
        inisialisasi objek dan perhitungan
        untuk nilai kembalian. Tdk harus ada yg di passing */
    val text = "Hello"
    val result = text.run {
        val from = this
        val to = this.replace("Hello", "Kotlin")
        "replace text from $from to $to" // return
    }
    println("result : $result") // Output: result : replace text from Hello to Kotlin
    run { println("Tamvan") } // Output: Tamvan

    // with (this)
    /* bukan extension tp fungsi biasa
    *  argument diakses dg this */
    val message = "Hello Kotlin!"
    val result1 = with(message) {
        println("value is $this")
        println("with length ${this.length}")
    }
    println(result1) // Output: kotlin.Unit
    /* dg return value */
    val result2 = with(message) {
        "First character is ${this[0]}" +
                " and last character is ${this[this.length - 1]}"
    }
    println(result2) // Output: First character ...

    // apply (this)
    /* nilai kembalian apply adlh konteks objeknya (implisit) */
    val message1: StringBuilder = StringBuilder().apply {
        append("Hello ")
        append("Kotlin!")
    }
    println(message1) // Output: Hello Kotlin!

    // let (it)
    /* banyak ditemukan pada objek non-null (nullable?) */
    val message2: String? = null
    message2?.let {
        val length = it.length * 2
        val text = "text length $length"
        println(text) // Output: text length ..
    }
    /* code diatas dapat mengurangi operator safe call */
    /* tdk seperti ini */
    val message3: String? = null
    val length1 = message3?.length ?: 0 * 2 // (message?.length ?: 0) * 2
    val text1 = "text length $length1"
    println(text1) // Output: text length ..
    /* dengan run respon objek null */
    val message4: String? = null
    message4?.let {
        val length = it.length * 2
        val text = "text length $length"
        println(text) // Output: text length ..
    } ?: run {
        val text = "message is null"
        println(text) // Output: message is null (if message4 = null)
        /* bisa dg return value */
    }

    // also (it)
    /*  menggunakan konteks objek/argument tanpa mengubahnya,
        mengembalikan nilai konteks objeknya sendiri (implisit) */
    val text2 = "Hello Kotlin"
    val result3 = text2.also {
        println("value length -> ${it.length}")
    }
    println("text2 -> $result3") // Output: Hello Kotlin
}

var msgs = "Kotlin"
fun funcPropReference() {
    // Function References
    /* mereferensikan fungsi dengan opt :: */
    fun isEvenNumber(number: Int) = number % 2 == 0
    val numbers = 1.rangeTo(10)
    val evenNumbers = numbers.filter(::isEvenNumber)
    println(evenNumbers) // Output: [2, 4, 6, 8, 10]
    /* untuk extensions function */
    fun Int.isEvenNumber() = this % 2 == 0
    val evenNumber1 = numbers.filter(Int::isEvenNumber)
    println(evenNumber1)  // Output: [2, 4, 6, 8, 10]

    // Property Reerences
    /* bisa akses nama funsi, setter/getter, dll */
    println(::msgs.name) // Output: msgs
    println(::msgs.get()) // Output: Kotlin
    ::msgs.set("Kotlin Academy")
    println(::msgs.get()) // Output: Kotlin Academy
    /* untuk objek immutable kita tdk bisa menggunakan setter */
    /* kembalian ::msgs -> KMutableProperty/KPropery */
}

fun foldDropTake() {
    // fold()
    /* interasi perhitungan setiap items pd collection */
    val numbers = listOf(1, 2, 3)
    val fold = numbers.fold(10) { current, item ->
        /*  current: nilai akhir
        *   item: nilai yg diiterasi */
        println("current $current")
        println("item $item")
        println()
        current + item
    }
    /* Output:
       current 10
       item 1

       current 11
       item 2

       current 13
       item 3

       Fold result: 16
    */

    // drop() or dropLast()
    /* membuang n item dari dpn/blkg */
    val number = listOf(1, 2,3 ,4 ,5, 6)
    val drop = number.drop(3)
    val drop2 = number.dropLast(3)
    println(drop) // Output: [4, 5, 6]
    println(drop2) // Output: [1, 2, 3]

    // take() or takeLast()
    /* mengambil n item dari dpn/blkg */
    val total = listOf(1, 2, 3, 4, 5, 6)
    val take = total.take(3)
    val take2 = total.takeLast(3)
    println(take) // Output: [1, 2, 3]
    println(take2) // Output: [4, 5, 6]
}

fun sliceDistinctChuncked() {
    // slice()
    /* ambil di posisi tertentu dr i..j index (inclusive) */
    val total = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val slice = total.slice(3..6) // idx: 3,4,5,6
    val slice2 = total.slice(3..6 step 2) // idx: 3,5
    println(slice) // Output: [4, 5, 6, 7]
    println(slice2) // Output: [4, 6]

    // distinct()
    /* menyaring nilai duplilkat */
    val total2 = listOf(1, 2, 1, 3, 4, 5, 2, 3, 4, 5)
    val distinct = total2.distinct()
    println(distinct) // Output: [1, 2, 3, 4, 5]
    /* untuk data class .. */
    data class Item(val key: String, val value: Any)
    val items = listOf(
        Item("1", "Kotlin"),
        Item("2", "is"),
        Item("3", "Awesome"),
        Item("3", "as"),
        Item("3", "Programming"),
        Item("3", "Language")
    )
    val distinctItems = items.distinctBy { it.key }
    distinctItems.forEach {
        println("${it.key} with value ${it.value}")
    }
    /*
    Output:
       1 with value Kotlin
       2 with value is
       3 with value Awesome
    */
    /* saring item by item.length */
    val text = listOf("A", "B", "CC", "DD", "EEE", "F", "GGGG")
    val distinct2 = text.distinctBy {
        it.length
    }
    println(distinct2) // Output: [A, CC, EEE, GGGG]
    /* tp distinct tdk dpt di pake di object collection */

    // chunked()
    /* mirip split() tp non-regex */
    val word = "QWERTY"
    val chunked = word.chunked(3)
    println(chunked) // Output: [QWE, RTY]
    val chunkedTransform_ = word.chunked(3) {
        it.toString().toLowerCase()
        /* it -> nilai yg sudah di pecah */
    }
    println(chunkedTransform_) // Output: output: [qwe, rty]
}

fun recursion() {
    // tanpa rekursi
    fun factorial(n: Int): Int {
        return if (n == 1) {
            n
        } else {
            var result = 1
            for (i in 1..n) {
                result *= i
            }
            result
        }
    }
    // dgn rekursi
    fun factorial2(n: Int): Int {
        return if (n == 1) {
            n
        } else {
            n * factorial(n - 1)
        }
    }
    /* ^ masih stackoverflow-able (stack frame terlalu dalam) */

    // tail call recursion
    /* pemanggilan fungsi rekursi di akhir */
    tailrec fun factorial3(n: Int, result: Int = 1): Int {
        val newResult = n * result
        return if (n == 1) {
            newResult // return: Int
        } else {
            factorial3(n-1, newResult) // return: Int
        }
    }
    /* dengan menambahkan modifier tailrec
    *  function hanya boleh dipanggil untuk dijalankan terakhir
    *  -- tidak boleh digunakan dalam blok try-catch-finally
    *  -- sudah tidak stackoverflow */
}