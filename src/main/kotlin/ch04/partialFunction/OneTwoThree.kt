package ch04.partialFunction

fun main(args: Array<String>) {
    // 값이 1, 2, 3 중 하나인지를 확인하는 함수
    val condition: (Int) -> Boolean = { it in 1..3 }

    // 조건이 맞을 때 실행할 함수
    val body: (Int) -> String = {
        when (it) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            else -> throw IllegalArgumentException() // 여기까지 안가고 condition 에서 잡히긴 함
        }
    }

    val oneTwoThree = PartialFunc(condition, body)

    if (oneTwoThree.isDefinedAt(3)) println(oneTwoThree(3))
    else println("isDefinedAt(x) return false")
    println(oneTwoThree.invoke(3))

    println("- - - - - - - - - - - - - - - - -")

    if (oneTwoThree.isDefinedAt(4)) println(oneTwoThree(4))
    else println("isDefinedAt(x) return false")
    println(oneTwoThree.invoke(4))
}