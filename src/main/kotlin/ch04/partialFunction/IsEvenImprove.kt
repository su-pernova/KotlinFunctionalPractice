package ch04.partialFunction

fun main(args: Array<String>) {
    // ((P) -> R) 형태의 함수 뒤에 붙여 쓸 수 있는 toPartialFunction 함수를 정의했다.
        // 이런 함수를 '확장 함수' 라고 한다.
        // 예) body.toPartialFunction(condition) = PartialFunction(condition, body)
    fun<P, R> ((P) -> R).toPartialFunction(definedAt: (P) -> Boolean)
            :PartialFunc<P, R> = PartialFunc(definedAt, this)

    val condition: (Int) -> Boolean = { it.rem(2) == 0 }
    val body: (Int) -> String = { "$it is even" }

    // val isEven = PartialFunction<Int, String>({ it % 2 == 0 }, { "$it is even" })
    // 위 기존 방식과 비교해보았을 때 훨씬 간단한 구문으로 부분 함수 생성이 가능하다.
    val isEven = body.toPartialFunction(condition)

    if (isEven.isDefinedAt(100)) println(isEven(100))
    else println("isDefinedAt(x) return false")
    isEven.invoke(100)

    println("- - - - - - - - - - - - - - - - -")

    if (isEven.isDefinedAt(101)) println(isEven(101))
    else println("isDefinedAt(x) return false")
    isEven.invoke(101)
}