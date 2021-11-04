package com.study.kotlinstudy

import java.lang.Appendable
import java.lang.StringBuilder

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

// 高阶函数
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun processTheAnswer(f: (Int, Int) -> Int) {
    println(f(42, 43))
}

fun main(args: Array<String>) {
    twoAndThree{ a, b -> a + b }
    twoAndThree{ a, b -> a * b }

    processTheAnswer { a, b -> a + b }

    println("ab1c".filter { it in 'a'..'z'})

    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println(calculator(Order(3)))

    val people = listOf<Person13>(Person13("Alice", 29), Person13("Bob", 31))
    println(people.filter { it.age < 30 })

    val result = mutableListOf<Person13>()
    for (person in people) {
        if (person.age < 30) result.add(person)
    }
    println(result)

    lookForAlice(people)

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
    println(listOf(1, 2, 3, 4).penultimate)

    println(max(1, 2))
    println(max("kotlin", "11"))

    val helloWord = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWord)
    println(helloWord)


}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

data class Person13(val name: String, val age: Int)

fun lookForAlice(people: List<Person13>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lookForAlice2(people: List<Person13>) {
    people.forEach lable@{
        if (it.name == "Alice") return@lable
    }
    println("Alice might be somewhere")
}

fun lookForAlice3(people: List<Person13>) {
    people.forEach {
        if (it.name == "Alice") return@forEach
    }
}

fun <T> List<T>.slice(indices: IntRange): List<T> {
    return listOf<T>()
}

val <T> List<T>.penultimate: T get() = this[size - 2]

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

// 为一个参数指定多个约束
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}







