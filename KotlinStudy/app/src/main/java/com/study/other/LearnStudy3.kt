package com.study.other
import com.study.kotlinstudy.Color
import com.study.kotlinstudy.Color.*
import com.study.kotlinstudy.lastChar
import com.study.kotlinstudy.lastChar as last

fun getWarmth(color: Color) = when (color) {
    YELLOW, RED -> "warm"
    ORANGE -> "cold"
}

fun main(args: Array<String>) {
    val c = "Kotlin".lastChar()
    val c1 = "Kotlin".last()
}

