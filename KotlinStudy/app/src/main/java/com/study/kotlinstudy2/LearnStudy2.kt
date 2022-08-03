package com.study.kotlinstudy2

import java.lang.IllegalArgumentException

//import com.study.kotlinstudy2.lastChar as last
//import com.study.kotlinstudy2.*
/**
 * @author mrzhang
 * @date 2022/7/30
 */
fun main(args: Array<String>) {
    val c = "Kotlin".lastChar()

    listOf("1", "2", "3").join()

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    val arg = arrayOf("1", "2", "3")
    val list = listOf("args: ", *arg)

    println("12.345-6.A".split("\\.|-".toRegex())) // 显式的创建一个正则表达式

    val filepath = "/Users/yole/kotlin-book/chapter.adoc"
    filepath.substringBeforeLast("/")
    filepath.substringAfterLast("/")

    val price = """$99.9"""
    println(price) // 输出$99.9

    test()
}

fun Collection<String>.join(separator: String = ", ", prefix: String = "", postfix: String = "") =
    joinToString(
        separator, prefix, postfix
    )

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir:$directory, name:$filename, ext:$extension")
    }
}

class User(val id: Int, val name: String, val address: String)
// 局部函数
fun saveUser(user: User) {
    fun validate(value: String, filedName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("exception")
        }
    }
    validate(user.name, "Names")
    validate(user.address, "Address")
}

// 扩展函数
fun User.validateBeforeSave() {
    fun validate(value: String, filedName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("exception")
        }
    }
    validate(name, "Names")
    validate(address, "Address")
}

fun saveUser2(user: User) {
    user.validateBeforeSave()
}

// 中缀函数
infix fun Any.toHash(value: String) = hashCode().toString() + value

fun test() {
    println("Int" toHash "1111")
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        super<Clickable>.showOff() // 与java中Clickable.super.showOff()中类似
        super<Focusable>.showOff()
    }
}

//open表示可继承
open class RichButton : Clickable {
    // 没有final的override意味着open
    final override fun click() {
        TODO("Not yet implemented")
    }

    fun disable() {

    }

    open fun animate() {

    }
}

abstract  class Animated {
    abstract fun animate()
    open fun stopAnimation() {}
    // 抽象类中的非抽象函数默认是非open的，但是可以标注为open
    fun animateTwice() {}
}

class Outer {
    // 默认是嵌套类，不持有外部引用；加了inner就是内部类，持有外部引用
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}



// 密封类，要求所有的子类必须嵌套在父类之中
sealed class Expr2 {
    class Num(val value: Int) : Expr2()
    class Sum(val left: Expr2, val right: Expr2) : Expr2()
}

fun eval(e: Expr2): Int =
    when(e) {
        is Expr2.Num -> e.value
        is Expr2.Sum -> eval(e.left) + eval(e.right)
    }

class User2 constructor(_nickName: String) {
    val nickName: String
    init {
        nickName = _nickName
    }
}

class User3(_nickName: String) {
    val nickName = _nickName
}



