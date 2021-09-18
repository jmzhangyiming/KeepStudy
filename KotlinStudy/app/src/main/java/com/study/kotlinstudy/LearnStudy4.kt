package com.study.kotlinstudy

import android.content.Context
import java.util.jar.Attributes

open class View4 {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: Attributes) {

    }
}

class MyButton : View4 {
    constructor(ctx: Context) : super(ctx) {

    }

    constructor(ctx: Context, attr: Attributes) : super(ctx, attr) {

    }
}
val MY_STYLE = Attributes()
class MyButton2 : View4 {
    constructor(ctx: Context) : this(ctx, MY_STYLE) {

    }

    constructor(ctx: Context, attr: Attributes) : super(ctx, attr) {

    }
}

interface User6 {
    val nickName: String
}

class PrivateUser(override val nickName: String) : User6

class SubscribingUser(val email: String) : User6 {
    override val nickName: String
    get() = email.substringBefore("@")
}

class FacebookUser(val accountId: Int) : User6 {
    override val nickName = "Name : ${accountId}"
}

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other. name && postalCode == other.postalCode
    }

    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }
}

data class Client2(val name: String, val postalCode: Int) {

}

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")
}

class DelegatingCollection2<T>(innerList: Collection<T>)

