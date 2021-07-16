package com.gayathri.preparation.kotlinconcepts

class SealedClasses {
}

fun main() {
    val paymentOption = PaymentOption.CARD
    println(paymentOption)
    /**
     * This doesn't work
     */
    /*when (getPaymentOption()) {
        is PaymentOption.CARD -> println("CARD")
        is PaymentOption.COD -> println("CARD")
        is PaymentOption.ONLINE -> println("CARD")
    }*/

    when (getAdType()) {
        is AdType.FacebookAd -> println("FACEBOOK")
        is AdType.GoogleAd -> println("GOOGLE")
        is AdType.OwnAd -> println("OWN AD")
        is AdType.ABCD -> println("ABCD")
    }

    when (getOwnAdType()) {
        is AdType.FacebookAd -> println("FACEBOOK")
        is AdType.GoogleAd -> println("GOOGLE")
        is AdType.OwnAd -> {
            println("OWN AD")
            val ad = getOwnAdType()
            println("OWN AD ${(ad as AdType.OwnAd).name}")
        }
    }
}

fun getPaymentOption() = PaymentOption.COD

fun getAdType(): AdType {
    return AdType.FacebookAd
}

fun getOwnAdType(): AdType {
    return AdType.OwnAd("Book", "")
}

// Another way to represent a concrete group of values is a sealed class
// Sealed classes are abstract classes with a concrete number of subclasses all defined in the same file
sealed class PaymentOption {
    object CARD
    object COD
    object ONLINE
}

// Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
// All subclasses of a sealed class are known at compile time.
// No other subclasses may appear after a module with the sealed class is compiled
sealed class AdType {
    object FacebookAd : AdType()
    object GoogleAd : AdType()
    data class OwnAd(val name: String, val image: String) : AdType()
    enum class GeneralAd()
    class ABCD() : AdType()
}

// No need of else in when using sealed class
