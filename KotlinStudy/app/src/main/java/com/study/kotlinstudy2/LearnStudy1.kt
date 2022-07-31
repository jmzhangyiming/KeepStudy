package com.study.kotlinstudy2

import java.lang.IllegalArgumentException
import java.util.*

data class Person(val name: String, val age: Int? = null) {

}

const val UNIX_LINE_SEPARATOR = "\n"

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The olest is: $oldest")

    val person = Person2("Bob", false)
    println(person.name)

    println(createRandomRectangle().isSquare)

    println(Color.ORANGE)

    println(getMnemonic(Color.ORANGE))

    Sum(Sum(Num(1), Sum(Num(2), Num(3))), Num(2))

    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 3) {
        println(fizzBuzz(i))
    }

//    for (x in 0 until size) == for (x in 0..size - 1)
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    String().lastChar()
}

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

class Person2(val name: String, val isMarried: Boolean)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), GREEN(0, 255, 0);
    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when(color) {
        Color.ORANGE , Color.GREEN -> "is"
        Color.RED -> "Richard"
    }

fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
        setOf(Color.RED, Color.ORANGE) -> "mix1"
        else -> "111"
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.GREEN && c2 == Color.ORANGE) -> "mix1"
        (c1 == Color.ORANGE && c2 == Color.RED) -> "mix2"
        else -> throw Exception("Dirty color")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw Exception("UnKonwn expression")
}

fun eval2(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval2(e.right) + eval2(e.left)
        else -> throw IllegalArgumentException("UnKnown expression")
    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "fizzBuzz"
    i % 3 == 0 -> "fizz"
    i % 5 == 0 -> "buzz"
    else -> "$i"
 }

fun String.lastChar() = get(length - 1)


