package ch04.composedFunction

fun main(args: Array<String>) {
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

    // 올바른 결과를 return 하는 composedGcdPowerOfTwo

}