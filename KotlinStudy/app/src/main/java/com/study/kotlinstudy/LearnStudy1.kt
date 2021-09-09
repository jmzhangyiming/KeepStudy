package com.study.kotlinstudy

import java.io.BufferedReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>) {
    println("Hello, world!")

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")

    if (args.size > 0) {
        println("Hello, ${args[0]}")
    }

    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")

    val rectangle = Rectangle(1, 1)
    println(rectangle.isSquare)

    val learnStudy2 = LearnStudy2()

    println(Color.ORANGE.rgb())

    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "101")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

class Person(val name: String)

class Person1(val name: String, var isMarried: Boolean)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255,0 , 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0);
    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) {
    when (color) {
        Color.ORANGE -> "orange"
        Color.RED -> "red"
        Color.YELLOW -> "yellow"
    }
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return e.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknow experssion")
}

fun eval1(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        e.value
    }
    if (e is Sum) {
        eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknow experssion")
}

fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknow experssion")
    }

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num : ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknow experssion")
        }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'F'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It is a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter!"
    else -> "I don't konw.."
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }
}

fun readNumber1(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }
    catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }
    catch (e: NumberFormatException) {
        return
    }
    println(number)
}