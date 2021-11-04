package com.study.kotlinstudy

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.circularreveal.CircularRevealHelper
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.lang.IndexOutOfBoundsException
import java.lang.reflect.Type
import java.time.LocalDate

class Point2(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point2) return false
        return other.x == x && other.y == y
    }
}

class Person10(val firstName: String, val lastName: String) : Comparable<Person10>{
    override fun compareTo(other: Person10): Int {
        return compareValuesBy(this, other, Person10::firstName, Person10::lastName)
    }
}

operator fun Point2.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    val p = MutablePoint(10, 20)
    p[1] = 42
    println(p)

    val rect = Rectangle2(Point2(10, 20), Point2(50, 50))
    println(Point2(20, 30) in rect)
    println(Point2(5, 5) in rect)

    for (c in "abc") {
        println(c)
    }

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (d in daysOff) {
        println(d)
    }

    val (name, ext) = splitFileName("example.kt")
    println(name)
    println(ext)

    val p11 = Person11("Dmitry", 34, 2000)
    p11.addPropertyChangeListener(
            PropertyChangeListener { event ->
                println("Property ${event.propertyName} changed " + "from ${event.oldValue} to ${event.newValue}")
            }
    )
    p11.age = 55
    p11.salary = 2100

    val sum = { x: Int, y: Int -> x + y }
    val action = {println(42)}

    val sum1: (Int, Int) -> Int = {x, y -> x + y}
    val action1: () -> Unit = { println(43)}

//    var canReturnNull: (Int, Int) -> Int? = { null }
    var fullOrNull: ((Int, Int) -> Int)? = null
}

data class Rectangle2(val upperLeft: Point2, val lowerRight: Point2)

operator fun Rectangle2.contains(p: Point2): Boolean {
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> = object : Iterator<LocalDate> {
    var current = start
    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun next(): LocalDate {
        return current.apply { current = plusDays(1) }
    }
}

data class NameComponents(val name: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

// 收工实现属性修改的通知
class Person11(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field =  newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field =  newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

// 通过辅助类来实现属性变化的通知
class ObservableProperty(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class Person12(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) {
            _age.setValue(value)
        }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) {
            _salary.setValue(value)
        }
}

