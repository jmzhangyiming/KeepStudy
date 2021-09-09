package com.study.other
import com.study.kotlinstudy.Color
import com.study.kotlinstudy.Color.*

fun getWarmth(color: Color) = when (color) {
    YELLOW, RED -> "warm"
    ORANGE -> "cold"
}