package com.study.kotlinstudy2

import java.util.*

data class Person(val name: String, val age: Int? = null) {

}

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The olest is: $oldest")

    val person = Person21("Bob", false)
    println(person.name)

    println(createRandomRectangle().isSquare)

    println(Color.ORANGE)

    println(getMnemonic(Color.ORANGE))
}

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

class Person21(val name: String, val isMarried: Boolean)

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

