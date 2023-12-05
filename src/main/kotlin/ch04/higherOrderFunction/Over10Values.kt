package ch04.higherOrderFunction

fun main(args: Array<String>) {
    val ints: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10)

    // 명령형 프로그래밍으로 작성하는 경우
    val over10Values: ArrayList<Int> = ArrayList()
    for (element in ints) {
        val twiceInt = element * 2
        if (twiceInt > 10) over10Values.add(twiceInt)
    }
    println(over10Values)
    println("- - - - - - - - - - -")

    // 컬렉션 API 와 고차 함수를 활용하는 경우
    // map, filter 는 매개변수로 함수를 받는 고차함수다.
    val result1 = ints.map { value -> value * 2 }
        .filter { value -> value > 10 }
    println(result1)
    println("- - - - - - - - - - -")

    // 코틀린 람다 표현식에서 매개변수로 받는 값이 하나인 경우(value) it 으로 간소화 가능하다.
    val result2 = ints.map { it * 2 }
        .filter { it > 10 }
    println(result2)
}
