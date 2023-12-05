package ch04.curryingFunction

fun main(args: Array<String>) {
    // 매개변수가 3개인 함수를 커링 함수로 변환하는 확장함수
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried():
                (P1) -> (P2) -> (P3) -> R = { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }

    // 커링 함수를 일반 함수로 변환하는 확장함수
    fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried():
                (P1, P2, P3) -> R = { p1: P1, p2: P2, p3: P3 -> this(p1)(p2)(p3) }

    val multiThree = { a: Int, b: Int, c: Int -> a * b * c }

    val curriedMultiThree = multiThree.curried()
    println(curriedMultiThree(1)(2)(3))

    val uncurriedMultiThree = curriedMultiThree.uncurried()
    println(uncurriedMultiThree(1, 2, 3))

    // 연습문제 4-4
        // 두 개의 매개변수를 받아서 작은 값을 반환하는 min 함수를 curried 함수를 사용해서 작성하라.
    fun <P1, P2, R> ((P1, P2) -> R).curried():
                (P1) -> (P2) -> R = { p1: P1 -> { p2: P2 -> this(p1, p2) } }

    val min = { x: Int, y: Int -> if (x > y) x else y }

    val curriedMin = min.curried()
    println(curriedMin(10)(20))
    println(curriedMin(100)(90))
}