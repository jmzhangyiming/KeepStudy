package com.study.kotlinstudy

import java.io.BufferedReader
import java.lang.NumberFormatException

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCode2(t: T) {
    
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result;
}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
 }

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x + 10, y + other.y + 10)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}



fun main(args: Array<String>) {
    verifyUserInput(" ")
    verifyUserInput("")
    verifyUserInput(null)

    printHashCode(null)

    val i = 1
    val l: Long = i.toLong()

    val x = 1
    println(x.toLong() in listOf(1L, 2L, 3L))

    val letters = Array<String>(26) {it -> ('a' + it).toString()}
    println(letters.joinToString())

    val p1 = Point(1, 1)
    val p2 = Point(2, 2)
    println(p1 + p2)
    println(p1 * 2.0)
    println('a' * 5)

    val numbers = ArrayList<Int>()
    numbers += 42
    numbers += 53
    println("${numbers[0]}, ${numbers[1]}")

    val list = arrayListOf(1, 2)
    list += 3
    val newlist = list + listOf(4, 5)
    println(list)
    println(newlist)
}