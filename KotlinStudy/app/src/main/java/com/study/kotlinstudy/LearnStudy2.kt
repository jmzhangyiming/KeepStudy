@file:JvmName("StringFunction")
package com.study.kotlinstudy

import java.lang.IllegalArgumentException

fun getWarmth(color: Color) = when (color) {
    Color.YELLOW, Color.RED -> "warm"
    Color.ORANGE -> "cold"
}

class LearnStudy2() {

}

private val s = joinToString(listOf(1, 2, 3), separator = ";", prefix = "{", postfix = "}")

fun main(args: Array<String>) {
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

    println(joinToString(listOf(1, 2, 3), "; ", "{", "}"))
    println(joinToString(listOf(1, 2, 3), separator = ";", prefix = "{", postfix = "}"))
    println(joinToString(listOf(1, 2, 3)))
    println(joinToString(listOf(1, 2, 3), ".."))

    println("Kotlin".lastChar())

    val list2 = listOf(1, 2, 3)
    println(list2.joinToString())

    val view: View = Button()
    view.click()

    val view2: View = Button()
    view2.showOff()

    val stringlist: List<String> = listOf("first", "second", "third")
    println(stringlist.last())

    val numberlist: Collection<Int> = setOf(1, 2, 3)
    println(numberlist.max())

    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))

    parsePath("/users/yole/kotlin-book/chapter.adoc")
    parsePath2("/users/yole/kotlin-book/chapter.adoc")

    test()

}

fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String{
    val result =  StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = get(this.length - 1)

fun <T> Collection<T>.joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String{
    val result =  StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a Button")

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePath2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

class User(val id: Int, val name: String, val adress: String)

// 局部函数
fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.adress, "Adress")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(adress, "Adress")
}

fun saveUser2(user: User) {
    user.validateBeforeSave()
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm Focusable!")
}

class Button2 : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() {
        TODO("Not yet implemented")
    }
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}

    override fun click() {
        TODO("Not yet implemented")
    }
}

open class RichButtonExtend : RichButton() {
    override fun animate() {

    }

}

abstract class Aniamted {
    abstract fun animate()

    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

class User2 constructor(_nickName: String) {
    val nickName: String

    init {
        nickName = _nickName
    }
}

class User3 constructor(_nickName: String) {
    val nickName = _nickName
}

class User4 constructor(val _nickName: String)

fun test() {
    var user2 = User2("2")
    println(user2.nickName)
    val user3 = User3("3")
    println(user3.nickName)
    val user4 = User4("4")
    println(user4._nickName)
}

open class User5(val nickName: String) {}
class TwitterUser(nickName: String) : User5(nickName) {}

open class Button3

class Secretive private constructor() {}


