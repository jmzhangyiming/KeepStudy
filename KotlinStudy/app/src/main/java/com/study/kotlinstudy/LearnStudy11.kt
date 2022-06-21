// 无调用方法或类Class "MainApplication" is never used警告
@file:Suppress("unused")
package com.study.kotlinstudy

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

interface _Expr

class _Num(val value: Int) : _Expr
class _Sum(val left: _Expr, val right: _Expr) : _Expr

fun _eval(e: _Expr): Int {
    if (e is _Num) {
        val n = e as _Num
        return n.value
    }
    if (e is _Sum) {
        return _eval(e.right) + _eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun _eval2(e: _Expr): Int = when (e) {
    is _Num -> e.value
    is _Sum -> _eval(e.right) + _eval(e.left)
    else -> throw IllegalArgumentException("Unknown expression")
}

fun fizzBuzz() {
   for (i in 100 downTo 1 step 2){ }
   for (X in 0 until 100){}
   for (x in 0..99){}
}

val map = hashMapOf(1 to "one", 7 to "seven")

fun String._lastChar(): Char {
    return get(length - 1)
}

var StringBuilder.lastChar2: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }






