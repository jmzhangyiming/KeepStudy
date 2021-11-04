package com.study.kotlinstudy

import java.lang.StringBuilder

private fun StringBuilder.serializeObject(obj: Any) {
    val kClass = obj.javaClass.kotlin
    val properties = kClass.annotations
    properties?.lastIndex ?: "b"

    properties.joinToString(this, prefix = "{", postfix = "}")


}

fun buildString2(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString3(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

fun main(args: Array<String>) {
    val s = buildString2 {
        it.append("Hello,")
        it.append("World!")
    }
    println(s)

    val s1 = buildString3 {
        this.append("Hello,")
        append("World!")
    }

    // 用变量保存带接受者的lambda
    val appendExcl: StringBuilder.() -> Unit = {
        this.append("!")
    }
    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)

    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" }
    with(map) { this[3] = "three" }
    println(map)


}
