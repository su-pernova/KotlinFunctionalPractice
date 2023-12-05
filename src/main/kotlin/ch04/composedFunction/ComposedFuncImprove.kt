package ch04.composedFunction

import kotlin.math.abs

fun main(args: Array<String>) {
    // infix : 확장함수가 입력 매개변수를 양쪽으로 받을 수 있도록 한다.
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }

    val addThree = { i: Int -> i + 3 }
    val twice = { i: Int -> i * 2 }

    // addThree(twice(x)) 와 동일
        // 실제 실행은 뒤에서부터 된다. (twice → addThree 순서로 실행됨)
    val composedFunc = addThree compose twice
    println(composedFunc(3))

    // 포인트 프리 스타일 프로그래밍
        // 함수 합성을 사용해 매개변수나 타입 선언 없이 함수를 만드는 방식
    val absolute = { i: List<Int> -> i.map { abs(it) } }
    val negative = { i: List<Int> -> i.map { -it }}
    val minimum = { i: List<Int> -> i.min() }

    val composed = minimum compose negative compose absolute

    println(composed(listOf(3, -1, 5, -2, -4, 8, 14)))

    // 연습문제 4-5
        // 숫자(Int)의 리스트를 받아서 최댓값의 제곱을 구하는 함수를 max, power 함수를 합성하여 만들어보자.
        // 위 함수를 compose 함수를 사용해 다시 작성해보자.
    val max = { i: List<Int> -> i.max() }
    val power = { i: Int -> i * i }

    val myComposed = power compose max

    println(myComposed(listOf(-1, -2, -3, -4, -5)))
    println(myComposed(listOf(1, 2, 3, 4, 5)))
}