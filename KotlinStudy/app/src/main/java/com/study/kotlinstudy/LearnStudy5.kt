package com.study.kotlinstudy

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val strings = listOf("abc", "cdef")
    println(strings.flatMap { it.toList() }.toSet())

    val naturalNumbers = generateSequence(0) { it + 1}
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    fun File.isInsideHiddenDirectory() = generateSequence(this) {it.parentFile}.any { it.isHidden }
    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())

    postponeComputation(100) { println(42)}

    createAllDoneRunnable().run()
    println("abc")
    println(null)


    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

class Book(val title: String, val authors: String)

fun postponeComputation(delay: Int, computation: () -> Unit) {

}

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done") }
}

fun alphabet(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder, {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet")
        this.toString()
    })
}

fun alphabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
    toString()
}

fun alphabet3() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}

fun strLenSafe(s: String?) = if (s != null) s.length else 0

fun printAllCaps(s: String?) {
    val allCaps = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val name: String?, val city: String)
class Company(val name: String, val address: Address?)
class Person8(val name: String, val company: Company?)
fun Person8.countryName(): String {
    val country = this.company?.address?.name
    return if (country != null) country else "Unknown"
}

fun printShippLabel(person: Person8) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(this)
        println("$name  $city")
    }
}

fun foo(s: String?) {
    // 运算数不为null就是第一个数，为null就是第二个数
    val t = s ?: ""
}

fun strLemSafe(s: String?) = s?.length ?: 0

class Person9(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person9 ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

class MyService {
    fun performAction(): String = "foo"
}







