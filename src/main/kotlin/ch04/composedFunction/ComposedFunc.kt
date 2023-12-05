package ch04.composedFunction

fun main(args: Array<String>) {
    fun addThree(i: Int) = i + 3
    fun twice(i: Int) = i * 2

    // 두 개의 함수를 합성해서 하나의 함수를 생성했다.
    fun composed(i: Int) = addThree(twice(i))

    println(composed(1))
}