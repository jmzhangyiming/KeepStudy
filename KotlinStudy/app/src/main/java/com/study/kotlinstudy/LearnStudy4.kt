package com.study.kotlinstudy

import android.content.Context
import java.io.File
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

class DelegatingCollection2<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList{}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectAdded = 0;
    
}

object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

object CaseInsenssitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Person3(val name: String) {
    object NameComparator : Comparator<Person3> {
        override fun compare(o1: Person3, o2: Person3): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(args: Array<String>) {
    val persons = listOf(Person3("Bob"), Person3("Alice"))
    println(persons.sortedWith(Person3.NameComparator))

    A.bar()

    val people = listOf(Person7("Alice", 29), Person7("Bob", 31))
    println(people.maxBy { it.age })

    val sum = {x: Int, y: Int -> x + y}
    println(sum(1,2))
    //lambda
    people.maxBy({p: Person7 -> p.age})
    people.maxBy() {p: Person7 -> p.age}
    people.maxBy {p: Person7 -> p.age}
    people.maxBy { p -> p.age }
    people.maxBy { it.age }

    val names = people.joinToString(separator = " ",  transform = {p -> p.name})
    println(names)

    val getAge = {p: Person7 -> p.age}
    people.maxBy(getAge)

    val sum2 = {x: Int, y: Int ->
        println("computing the sum of $x and $y...")
        x + y
    }

    println(sum2(1, 2))

    val getAge2 = Person7::age
    people.maxBy(Person7::age)
    run(::salute)
    run(::nextAction)

    val createPerson = ::Person7
    val p = createPerson("Alice", 29)
    println(p)

    val p2 = Person7("Dmity", 34)
    val personAgeFunction = Person7::age
    println(personAgeFunction(p2))

    val dmityAgeFunction = p2::age
    println(dmityAgeFunction())

    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val people3 = listOf(Person7("Alice", 29), Person7("Bob", 31))
    println(people3.map { it.name })
    println(people3.filter { it.age > 30 }.map { it.name })
    println(people3.filter { it.age > 30 }.map { Person7::name })

    val maxAge = people3.maxBy(Person7::age)?.age
    println(people3.filter { it.age == maxAge })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues{ it.value.toUpperCase() })

    val canBeInClub27 = {p: Person7 -> p.age <= 27}
    println(people3.all(canBeInClub27))
    println(people3.any(canBeInClub27))
    println(people3.count(canBeInClub27))

    val people4 = listOf(Person7("Alice", 29), Person7("Bob", 31), Person7("Tom", 31))
    println(people4.groupBy { it.age })
    val list2 = listOf("a", "b", "c")
    println(list2.groupBy(String::first))
    println(list2.groupBy { str: String -> str.first() })
    println(list2.groupBy { it.first()})

    people4.asSequence().map(Person7::name).filter { it.startsWith("A") }.toList()
}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

// 工厂方法
class User7 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User7("Bob")
        fun newFacebookUser(accountId: Int) = User7("Aoa")
    }
}

class Person5(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person = Person("Bob")
    }
}

class Person6(val firstName: String, val lastName: String) {
    companion object {

    }
}

fun Person6.Companion.fromJSON(json: String): Person6 {
    return Person6("Bob", "Aoa")
}

data class Person7(val name: String, val age:Int) {

}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun salute() = println("Salute")

fun sendEmail(person: Person7, message: String) {
    println("$person")
}

val action = {person: Person7, message: String ->
    sendEmail(person, message)
}
val nextAction = ::sendEmail

