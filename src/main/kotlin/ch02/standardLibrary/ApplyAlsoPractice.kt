package ch02.standardLibrary

import ch02.common.Person

fun main() {
    val person = Person("FP", 30)

    // 3. using apply (객체 반환 코드를 작성할 필요가 없다)
    val applyResult = person.apply {
        name = "KotlinApply"
        age = 1
    }
    println(applyResult)

    // 4. using also (it, this 로 접근하는 것 외 나머지는 apply 와 동일)
    val alsoResult = person.also {
        it.name = "KotlinAlso"
        it.age = 2
    }
    println(alsoResult)
}