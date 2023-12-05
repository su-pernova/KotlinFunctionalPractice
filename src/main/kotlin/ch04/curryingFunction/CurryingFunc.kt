package ch04.curryingFunction

fun main(args: Array<String>) {
    fun multiThree(a: Int, b: Int, c: Int): Int = a * b * c

    println(multiThree(1, 2, 3))

    // 부분 적용 함수를 사용해 chain 을 만들었다.
    // 매개변수가 한 개인 부분 적용 함수의 체인이므로 커링 함수이다.
    // 커링 함수의 장점
    // 부분 적용 함수를 다양하게 재사용할 수 있다.
    // 마지막 매개변수가 입력될 때까지 함수 실행을 늦출 수 있다.
    fun multiThreeChain(a: Int) = { b: Int -> { c: Int -> a * b * c } }
    val multiThreeChain1 = multiThreeChain(1)
    val multiThreeChain2 = multiThreeChain1(2)
    val multiThreeChain3 = multiThreeChain2(3)

    println(multiThreeChain3)
    println(multiThreeChain(1)(2)(3)) // 이런 형태로 호출이 가능하다.

    // 연습문제 4-3
    // 두 개의 매개변수를 받아서 큰 값을 반환하는 max 함수를 커링을 사용할 수 있도록 구현하라.
    fun maxChain(a: Int) = { b: Int -> if (a > b) a else b }

    val maxChain1 = maxChain(10)
    val maxChain2 = maxChain1(20)
    println(maxChain2)

    val maxChainA = maxChain(25)
    val maxChainB = maxChainA(15)
    println(maxChainB)
}