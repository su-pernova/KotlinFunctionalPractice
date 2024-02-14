package ch04.composedFunction

fun main(args: Array<String>) {
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }

    fun <P1, P2, R> ((P1, P2) -> R).curried():
                (P1) -> (P2) -> R = { p1: P1 -> { p2: P2 -> this(p1, p2) } }

    tailrec fun gcd(m: Int, n: Int): Int = when (n) {
        0 -> m
        else -> gcd(n, m % n)
    }

    tailrec fun power(x: Double, n: Int, acc: Double = 1.0): Double = when (n) {
        0 -> acc
        else -> power(x, n - 1, x * acc)
    }

    val powerOfTwo = { x: Int -> power(x.toDouble(), 2).toInt() }
    // 두 개의 값을 받아서 각 값을 제곱한 값의 최대공약수를 구하는 함수
    val gcdPowerOfTwo = { x1: Int, x2: Int -> gcd(powerOfTwo(x1), powerOfTwo(x2)) }
    println(gcdPowerOfTwo(25, 5))

    // 잘못된 composedGcdPowerOfTwo
    val curriedGcd1 = :: gcd.curried()
    // val curriedGcd1 = { m: Int, n: Int -> gcd(m, n) }.curried()
        // gcd.curried() 를 하면 함수의 반환값인 Int 타입를 얻지만
        // :: gcd.curried() 를 하면 gcd 함수의 원형인 ((Int, Int) -> Int) 타입을 얻는다.
        // :: gcd 는 { (m: Int, n: Int) -> gcd(m, n) } 과 동일
    val composedGcdPowerOfTwo1 = curriedGcd1 compose powerOfTwo
    println(composedGcdPowerOfTwo1(25)(5))

    // 올바른 결과를 return 하는 composedGcdPowerOfTwo
    val curriedGcd2 = { m: Int, n: Int -> gcd(m, powerOfTwo(n)) }.curried()
        // 모양이 이상하죠? 여러개의 매개변수에 동일한 함수를 적용해야 할 때 함수 합성을 사용하는 것은 적합하지 않다.
        // gcdPowerOfTwo 처럼 일반적인 고차 함수로 연결하는 것이 좋다.
    val composedGcdPowerOfTwo2 = curriedGcd2 compose powerOfTwo
    println(composedGcdPowerOfTwo2(25)(5))
}