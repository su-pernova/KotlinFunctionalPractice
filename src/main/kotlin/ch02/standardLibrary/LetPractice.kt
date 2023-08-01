package ch02.standardLibrary

import ch02.common.Person
import ch02.common.User

fun main() {
    // 1. 객체 변경
    // without let
    val person = Person("FP", 30)

    person.name = "Kotlin1"
    person.age = 1
    println(person)

    // using let
    val result = person.let {
        it.name = "Kotlin2"
        it.age = 2
        it
    }
    println(result)

    // 2. Null 처리
    val user = User("Anna", "Kim")

    // without let
    fun printUserName1(user: User?) {
        if(user != null) println(user.firstName)
    }
    printUserName1(user)
    printUserName1(null)

    // using let
    fun printUserName2(user: User?) {
        user?.let { println(it.firstName) }
    }
    printUserName2(user)
    printUserName2(null)

    fun createUserName(user: User?): String {
        // ?.let 은 왼쪽 값이 null 인 경우 null 을 반환
        // ?: 는 왼쪽 값이 null 인 경우 오른쪽 값을 반환
        return user?.let { it.firstName + it.lastName } ?: "DefaultName"
    }
    println(createUserName(user))
    println(createUserName(null))
}