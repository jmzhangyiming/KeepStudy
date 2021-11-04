package com.study.kotlinstudy

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.reflect.KClass

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> Iterable<*>.filterIsInstance(): List<T> {
    val destnation = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destnation.add(element)
        }
    }
    return destnation
}
inline fun <reified T> loadService() {
    ServiceLoader.load(T::class.java)
}

inline fun <reified T: Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }

    operator fun <T: Any> get(kClass: KClass<T>): FieldValidator<T> = validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}

@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {

}

fun main(args: Array<String>) {
    // java.lang.IllegalArgumentException: List is expected
//    printSum(setOf(1, 2, 3))
    // java.lang.String cannot be cast to java.lang.Number
//    printSum(listOf("a", "b", "c"))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

    val serviceImpl = ServiceLoader.load(Service::class.java)
    val serviceImpl2 = loadService<Service>()

    remove(1)

}