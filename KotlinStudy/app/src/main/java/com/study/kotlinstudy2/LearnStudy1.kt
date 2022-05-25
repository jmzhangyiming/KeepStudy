package com.study.kotlinstudy2

data class Person(val name: String, val age: Int ?= null) {

}

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))
}

class LearnStudy1 {
}