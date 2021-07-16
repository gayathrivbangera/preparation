package com.gayathri.preparation.kotlinconcepts

import com.gayathri.preparation.kotlinconcepts.DaysOfWeek.Companion.today
import com.gayathri.preparation.kotlinconcepts.DaysOfWeek.Companion.todayEqual

/**
 * Unlike Java enums, Kotlin enums are classes.
 * Each of the enum constants acts as separate instances of the class and separated by commas.
 * Enums increases readability of your code by assigning pre-defined names to constants.
 * An instance of enum class cannot be created using constructors.
 * An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
 * separate the constants with a comma.
 */

class EnumClasses {
}

fun main() {
    when (getGeneralAd()) {
        GeneralAd.BOOK -> println("BOOK")
        GeneralAd.VEHICLE -> println("VEHICLE")
        GeneralAd.GROCERY -> println("GROCERY")
        GeneralAd.CLOTH -> println("CLOTH")
    }

    val color = Cards.Diamond.color
    println("color $color")

    // A simple demonstration of properties and methods
    for (day in DAYS.values()) {
        println("ordinal ${day.ordinal} = name ${day.name}")
    }

    /**
     * IllegalArgumentException
     * println("${DAYS.valueOf("Wednesday")}")
     */
    println("${DAYS.valueOf("WEDNESDAY")}")
    println(MONTHS.JAN.value)
    println(MONTHS.FEB.value)

    for (month in MONTHS.values()) {
        println("ordinal ${month.ordinal} = name ${month.name} & value is ${month.value}")
    }

    when (MONTHS.JAN) {
        MONTHS.JAN -> println("This is ${MONTHS.JAN.value}")
        MONTHS.FEB -> println("This is ${MONTHS.FEB.value}")
        /**
         * Adding an else clause will generate a warning
         * 'when' is exhaustive so 'else' is redundant here, Remove else branch
         */
        else -> println("else")
    }
    /**
     * Error
     * println(MONTHS.valueOf("January"))
     * Works
     * println(MONTHS.valueOf("JAN"))
     */

    println(MONTHS.isFirstMonth(MONTHS.JAN))


    for (day in DaysOfWeek.values()) {
        println("${day.ordinal} = ${day.name} and is weekend ${day.isWeekend}")
    }
    val today = DaysOfWeek.MONDAY;
    println("Is today a weekend ${today(today)}")

    println("Is today a weekend ${today(DaysOfWeek.SUNDAY)}")

    println("Is today equal to a weekend ${todayEqual(DaysOfWeek.SATURDAY)}")
}

fun getGeneralAd(): GeneralAd {
    return GeneralAd.BOOK
}

// enum classes cannot inherit from classes , cannot be extended
enum class GeneralAd {
    BOOK,
    VEHICLE,
    GROCERY,
    CLOTH
}

// No need of else in when using enum class

/**
 * Initializing enums –
 * In Kotlin also enums can have a constructor like Java enums.
 * Since enum constants are instances of an Enum class,
 * the constants can be initialized by passing specific values to the primary constructor.
 */
enum class Cards(val color: String) {
    Diamond("black"),
    Heart("red"),
}

//We can easily access the color of a card using –
val color = Cards.Diamond.color


enum class DAYS {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

enum class MONTHS(val value: String) {
    JAN("January"),
    FEB("February");

    companion object {
        fun isFirstMonth(month: MONTHS) = month.name == JAN.name
    }
}

/**
 * As in Java and in other programming languages,
 * Kotlin enum classes has some inbuilt properties and functions which can be used by the programmer.
 * Here’s a look at the major properties and methods.

Properties –

ordinal: This property stores the ordinal value of the constant, which is usually a zero-based index.
name: This property stores the name of the constant.

Methods –

values: This method returns a list of all the constants defined within the enum class.
valueOf: This methods returns the enum constant defined in enum, matching the input string.
If the constant, is not present in the enum, then an IllegalArgumentException is thrown.

 */

// A property with default value provided
enum class DaysOfWeek(val isWeekend: Boolean = false) {
    SUNDAY(true),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,

    // Default value overridden
    SATURDAY(true);

    companion object {
        fun today(obj: DaysOfWeek): Boolean {
            println("log ${obj.name.compareTo("SATURDAY")}")
            println("log ${obj.name.compareTo("SUNDAY")}")
            return obj.name.compareTo("SATURDAY") == 0 || obj.name.compareTo("SUNDAY") == 0
        }

        fun todayEqual(obj: DaysOfWeek): Boolean {
            println("log ${obj.name == "SATURDAY"}")
            println("log ${obj.name == "SUNDAY"}")
            return obj.name == "SATURDAY" || obj.name == "SUNDAY"
        }
    }
}