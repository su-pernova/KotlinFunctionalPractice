package ch04.partiallyAppliedFunction

fun main(args: Array<String>) {
    fun <P1, P2, R> ((P1, P2) -> R).partial1(p1: P1): (P2) -> R { return { p2 -> this(p1, p2) } }
    fun <P1, P2, R> ((P1, P2) -> R).partial2(p2: P2): (P1) -> R { return { p1 -> this(p1, p2) } }

    val func = { a: String, b: String -> "$a, $b" }

    val partiallyAppliedFunc1 = func.partial1("First") // P1 을 "First" 로 설정
        // partiallyAppliedFunc1 : func 에서 a 부분만 적용된 부분 적용 함수이다.
    println(partiallyAppliedFunc1("None")) // P2 값 "None" 을 받음

    val partiallyAppliedFunc2 = func.partial2("Second") // P2 를 "Second" 로 설정
        // partiallyAppliedFunc1 : func 에서 b 부분만 적용된 부분 적용 함수이다.
    println(partiallyAppliedFunc2("None"))  // P1 값 "None" 을 받음

    println("- - - - - - - - - - - -")

    // 연습문제 4-2
        // 매개변수 3개를 받는 부분 적용 함수 3개를 직접 구현하라
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1): (P2, P3) -> R { return { p2, p3 -> this(p1, p2, p3) } }
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial2(p2: P2): (P1, P3) -> R { return { p1, p3 -> this(p1, p2, p3) } }
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial3(p3: P3): (P1, P2) -> R { return { p1, p2 -> this(p1, p2, p3) } }

    val myFunc = { a: String, b: String, c: String -> "$a, $b, $c" }

    val myPartiallyAppliedFunc1 = myFunc.partial1("First")
    println(myPartiallyAppliedFunc1("None", "None"))

    val myPartiallyAppliedFunc2 = myFunc.partial2("Second")
    println(myPartiallyAppliedFunc2("None", "None"))

    val myPartiallyAppliedFunc3 = myFunc.partial3("Third")
    println(myPartiallyAppliedFunc3("None", "None"))
}