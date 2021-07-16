package com.gayathri.preparation.kotlinconcepts

class KotlinSafe {
}

/*
 Get rid of those pesky NullPointerExceptions, you know, The Billion Dollar Mistake
*/

fun main() {
    var output: String
//    output = null // Compilation error

    // Kotlin protects you from mistakenly operating on nullable types

    val name: String? = null // Nullable type
//    println(name.length) // Compilation error
}

fun calculateTotal(obj: Any) {
    if (obj is Invoice)
        obj.calculateTotal()
}

data class Invoice(
    val id: String
) {
    fun calculateTotal() {

    }
}