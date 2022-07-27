package com.study.kotlinstudy2

data class Person(val name: String, val age: Int? = null) {

}

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The olest is: $oldest")



}

fun max(a: Int, b: Int): Int {
    return if(a > b) a else b
}

class Person21(val name: String)

