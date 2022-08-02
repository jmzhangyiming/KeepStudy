package com.study.kotlinstudy2

import android.content.Context
import android.util.AttributeSet

/**
 * @author mrzhang
 * @date 2022/8/1
 */
fun main(args: Array<String>) {
    val carol = User4("Carol", isSubscribed = false)

    val bob = Client("Bob", 123)
    println(bob.copy("aoa"))

    val collection = DelegatingCollection<Int>()
    collection.isEmpty()

    Payroll.calculateSalary()
    Person4.fromJSON("name")
    Person4.Loader.fromJSON("name")

    loadFromJSON(Person5)
}

class User4(val nickName: String, val isSubscribed: Boolean = false) {

}

open class Button2
class RadioButton: Button2()

class Secretive private constructor() {}

// 从构造方法
open class View {
    constructor(ctx: Context) {

    }
    constructor(ctx: Context, attr: AttributeSet) {

    }
}

class MyButton: View {
    constructor(ctx: Context) : super(ctx) {

    }
    constructor(crtx: Context, attr: AttributeSet) : super(crtx, attr) {

    }
}

interface User5 {
    // 接口声明抽象属性
    val nickName: String
}

// 主构造方法初始化抽象属性
class PrivateUser(override val nickName: String) : User5
// 自定义getter方法
class SubscribingUser(val email: String) : User5 {
    override val nickName: String
    get() = email.substringBefore("@")
}

interface User6 {
    // 在子类必须重写
    val email: String
    // 可以被继承
    val nickName: String
        get() = email.substringBefore('@')
}

class LengthCounter {
    var counter: Int = 0
        // 不能在类外部修改这个属性
        private set
}

// 自动生成toString、equals、hashcode方法
data class Client(val name: String, val postalCode: Int)

// 类委托 by
class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList{
}

// object对象声明
object Payroll {
    val allEmployee = arrayListOf<Person>()
    fun calculateSalary() {
    }
}
// 伴生对象
class Person4(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String) {

        }
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person5(val name: String) {
    companion object : JSONFactory<Person5> {
        override fun fromJSON(jsonText: String): Person5 {
            TODO("Not yet implemented")
        }
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("111")
}
