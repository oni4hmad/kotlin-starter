package com.dicoding.kotlin

import java.util.*

class App {
}

// single line comment

/*
   multi line comment
   Hello Kotlin
*/

fun main() {
    val name = "Oni"
    print("Hello my name is ")
    println(name)
    println(if (true) "Always true" else "Always false")

    // materi variable
    variable()

    // materi char dan string
    charDanString()

    // materi function
    val user = setUser("Oni", 21)
    println(user)
    printUser("Ahmad Aunul M.")

    // materi if expression
    officeHours()

    // materi boolean
    boolean()

    // materi number
    number()

    // materi array
    arrayFunc()

    // materi nullable variable
    nullableVar()

    // materi safe calls / elvis operator
    safeCalls()

    // materi string template
    stringTemplate()

    // ----------- Control Flow -----------
    // Enumeration
    enumFunc()

    // Expressions dan Statements
    expVsStatment()

    // When Expression
    whenExp()

    // Expression & Statement
    expVsStatment()

    // While and Do While
    doWhile()

    // Range and For Loop
    rangeForLoop()

    // Break and Continue Labels
    breakAndContinue()
}

fun variable() {
    var company : String = "Dicoding"
    company = "Dicoding Academy" // re-assigning
    println(company)
    // company -> nama variable / identifier
    // String -> tipe data
    // "Dicoding Academy" -> inizialization

    val companyImu : String = "DicodingA" // Immutable
    println(companyImu)

    // tipe data implisit (type inference)
    val perusahaan = "DicodingB"
    println(perusahaan)

    // tipe data menentukan operasi yang dilakukan
    val firstWord = "Oni "
    val lastWord = "Ahmad"
    println(firstWord + lastWord) // string concat

    val valueA = 10
    val valueB = 20
    println(valueA + valueB) // penjumlahan integer

    // coba mutable variable
    var valueX = "ini string"
    valueX = 12.toString() // can only assign string coz its string at first
    println(valueX)
}

fun charDanString() {
    // Increment pada char
    var vocal = 'A'
    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)

    // String and indexing
    val text = "Kotlin"
    val firstChar = text[0]
    println("The first character of $text is $firstChar")

    // Iterasi char
    for (charr in text) {
        print("$charr \n")
    }

    // Escaped string
    println("Kotlin is \"Awesome\"")

    // Multiline string / Raw String
    val line = "line-1\n" +
            "line-2\n" +
            "line-3\n" +
            "line-4\n"
    println(line)

    val rawString = """
        line 1
        line 2
        line 3
        line 4
    """.trimIndent()
    println(rawString)
}

fun setUser(name: String, age: Int): String {
    return "Your name is $name, and you $age years old."
}

/*
    one line version / menggunakan expression body (untuk fungsi yang memiliki 1 statement)
    fun setUser(name: String, age: Int): String = "Your name is $name, and you $age years old."
 */

fun printUser(name: String): Unit {
    println("Your name is $name")
}

/*
    Unit sama dgn void atau bisa tidak ditulis jg gpp
*/

fun officeHours() {
    val openHours = 7
    val now = 20
    val office: String

    if (now > openHours) {
        println("office already open")
    }

//    if (now > openHours) {
//        office = "office already open"
//    } else {
//        office = "office is closed"
//    }
    office = if (now > openHours) {
        "office already open"
    } else if (now == openHours) {
        "wait a minute, office will be open"
    } else {
        "office is closed"
    }
    println(office + "!")
}

fun boolean() {
    val officeOpen = 7
    val officeClosed = 16
    val now = 20
//    val isOpen = if (now >= officeOpen && now <= officeClosed) {
//        true
//    } else {
//        false
//    }
    val isOpen = now >= officeOpen && now <= officeClosed
    println("Office is open : $isOpen")
    val isClose = now < officeOpen || now > officeClosed
    println("Office is close : $isClose")
    println(if(!isOpen) "not open!" else "open!")
}

fun number() {
    // type casting
//    val byteNumber : Byte = 0b00000011 // 3
    val byteNumber : Byte = 1
    val intNumber: Int = byteNumber.toInt()
    println(intNumber)

    // readable number
    val readableNum = 1_000_000
    println(readableNum) // 1000000
}

fun arrayFunc() {
    val array = arrayOf(1, 2, 3, 4, 5)
    println(Arrays.toString(array))
    val mixArray = arrayOf(1, 2, 3, 4, "Oni", true)
    println(Arrays.toString(mixArray))
    val intArray = intArrayOf(1, 2, 3, 4)
    println(Arrays.toString(intArray) + " | index-1: " + intArray[1])
    val intArrayAdv = Array(4, { i -> i * i }) // 4 iteration: 0 1 2 3
    println(Arrays.toString(intArrayAdv))
}

fun nullableVar() {
//    val text: String = null // compile time error
    val text: String? = null // OK
//    val textLength = text.length // compile time error

    // safe call (primitif)
    if (text != null) {
        val textLength = text.length // OK
    }
}

fun safeCalls() {
    // safe calls operator (?.)
    val text: String? = null
    println(text?.length)

    // elvis operator (?:) / null default value
    val txt: String? = null
    val textLength = txt?.length ?: 99
    // mirip: val textLength = if (txt.length != null) txt.length else 99
    println(textLength)

    // non-null assertion -> memaksa tetap memunculkan NullPointerException
//    val teks: String? = null
//    val teksLength = teks!!.length // OK ? NullPointerException
//    println(teksLength)
}

fun stringTemplate() {
    // string template
    val nama = "Kotlin"
    val umur = 21
    println("My name is $nama, i'm $umur years old.")

    // string template + expression
    val hour = 7
    println("Office ${if (hour > 7) "already close" else "is open"}")
}

//enum class Color {
//    RED, GREEN, BLUE // Instance dari class enum
//}

//enum class Color(val value: Int) {
//    // inisialisasi enum dengan value
//    RED(0xFF0000),
//    GREEN(0x00FF00),
//    BLUE(0x0000FF)
//}

enum class Color(val value: Int) {
    // inisialisasi enum anonymous class
    RED(0xFF0000) {
        override fun printValue() {
            println("value of RED is $value")
        }
    },
    GREEN(0x00FF00) {
        override fun printValue() {
            println("value of GREEN is $value")
        }
    },
    BLUE(0x0000FF) {
        override fun printValue() {
            println("value of BLUE is $value")
        }
    };

    abstract fun printValue()
}

enum class NamaOrang(val value : String) {
    Oni("Oni Ahmad"),
    Fio("Fiody Arditho"),
    Fajar("Fajar Satria")
}

fun enumFunc() {
    val color : Color = Color.RED
    println(color) // RED

    val nama : NamaOrang = NamaOrang.Fajar
    println("$nama - ${nama.value}") // Fajar - Fajar Satria

    Color.BLUE.printValue()

    // enum class synthetic method
    val colors : Array<Color> = Color.values() // atau: enumValues() (menyesuaikan dengan tipe data)
    colors.forEach { color ->
        print("$color : ${color.ordinal}, ") // RED : 0, GREEN : 1, BLUE : 2,
    }
    // valueOf()
    val warna : Color = Color.valueOf("RED") // RED, atau bisa pake enumValueOf("RED")
    println(warna)

    // mengecek instance dari enmun dengan when
    // setiap instance harus diimplementasikan
    when (color) { // RED
        Color.RED -> println("Color is Red")
        Color.GREEN -> println("Color is Green")
        Color.BLUE -> println("Color is Blue")
    }
}

fun expVsStatment() {
    // statement (tidak mengembalikan nilai)
    val openOffice = 7
    val now = 8
    if (now > openOffice) {
        println("Office already open")
    } else {
        println("Office close")
    }

    // expression (statement yg bisa mengembalikan nilai dan bisa disimpan di variable)
    val office = if (now > openOffice) "Office already open" else "Office close"
    println(office)

    // expression di dalam expression
    fun sum(value1: Int, value2: Int) = value1 + value2
    println(sum(1, 1*4))
}

fun whenExp() {
    // when statement
    val value = 7
    when(value) {
        6 -> println("value is 6")
        7 -> {
            println("----------")
            println("value is 7")
            println("----------")
        }
        8 -> println("value is 8")
        else -> println("value cannot be reached")
    }

    // when expression
    val stringOfValue = when(value) {
        6 -> "value is 6"
        7 -> "value is 7"
        8 -> "value is 8"
        else -> "value cannot be reached"
    }
    println(stringOfValue)

    // when untuk check tipe data
    val anyType : Any = 100L
    when(anyType) {
        is Long -> println("the value has long type")
        is String -> println("the value has string type")
        is Double -> println("the value has double type")
        else -> println("undefined")
    }

    // when untuk range atau collection
    val nilai = 27
    val ranges = 10..50
    when(nilai) {
        in ranges -> println("value is in the range")
        !in ranges -> println("value is not in the range")
        else -> println("value undefined")
    }

    // when dengan local variable
    fun getRegisterNumber() = kotlin.random.Random.nextInt(100)
    val registerNumber = when(val regis = getRegisterNumber()) {
        in 1..50 -> 50 * regis
        in 51..100 -> 100 * regis
        else -> regis
    }
    println(registerNumber)

    /*
    * when di pakai apabila kondisi lebih dari dua seperti switch case
    * sedangkan if dipakai apabila kurang dari dua
    * */

}

fun doWhile() {
    // contoh while
    var counter = 1
    while (counter <= 7) {
        println("Hello Dunia!")
        counter++
    }

    // contoh do while
    var i = 8
    do {
        println("Hello dari do while!")
    } while (i <= 7)


}

fun rangeForLoop() {
    // range menggunakan operator ..
    val rangeInt = 1..10 step 2
    rangeInt.forEach() {
        print("$it ")
        if (it == 9) print("\n")
    }
    println(rangeInt.step) // 2

    // range menggunakan rangeTo / downTo
    val rangeBaru = 1.rangeTo(10)
    rangeBaru.forEach {
        print("$it ")
        if (it == 10) print("\n")
    } // 1 2 3 4 5 6 7 8 9 10
    val tenToOne = 10.downTo(1)
    tenToOne.forEach {
        print("$it ")
        if (it == 1) print("\n")
    } // 10 9 8 7 6 5 4 3 2 1
    if (7 in tenToOne) {
        println("value 7 available")
    } // value 7 available
    if (11 !in tenToOne) {
        println("no value 11 in range")
    }

    // char range
    val rangeChar = 'A'.rangeTo('F')
    rangeChar.forEach {
        print("$it ")
        if (it == 'F') print("\n")
    }

    // for loop
    val ranges = 1..5
    for (i in ranges) {
        println("value is $i")
    }

    val num = 1.rangeTo(10) step 3
    for (i in num) {
        println("value is $i!!")
    }

    for ((idx, value) in num.withIndex()) {
        println("value $value with index $idx")
    }

    num.forEach { value ->
        println("!value is $value")
    }

    num.forEachIndexed { idx, value ->
        println("!!value $value with idx $idx")
    }

    num.forEachIndexed { idx, _ ->
        println("!>? index $idx")
    }
}

fun breakAndContinue() {
    // break dan continue
    val listOfInt = listOf(1, 2, 3, null, 5, null, 7)
    for (i in listOfInt) {
        if (i == null) continue
        print("$i ")
    } // 1 2 3 5 7
    print("\n")
    for (i in listOfInt) {
        if (i == null) break
        print("$i ")
    } // 1 2 3
    print("\n")

    // loop label
    loop@ for (i in 1..10) {
        println("Outside loop : $i")
        for (j in 1..10) {
            println("-- Inside loop : $j")
            if (j > 5) break@loop
        }
    }
}