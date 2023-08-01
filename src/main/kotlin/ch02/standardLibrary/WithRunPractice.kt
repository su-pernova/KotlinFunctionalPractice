package ch02.standardLibrary

import ch02.common.Person

fun main() {
    val person = Person("FP", 30)

    // 1. using with (it, this 불필요. 직접 접근 가능)
    val withResult = with(person) {
        name = "KotlinWith"
        age = 1
        this // 람다 리시버에서도 객체 자체에 접근할 때는 this 를 사용한다.
    }
    println(withResult)

    // 2-1. using run (it, this 불필요 + 확장함수)
    val runResult1 = person.run {
        name = "KotlinRun1"
        age = 2
        this
    }

    // 2-2. run 함수의 두 번째 선언 : 객체 생성 명령문을 하나의 블록으로 묶는 용도로 사용
    println(runResult1)
    val runResult2 = run {
        val name = "KotlinRun2"
        val age = 3
        Person(name, age)
    }
    println(runResult2)
}