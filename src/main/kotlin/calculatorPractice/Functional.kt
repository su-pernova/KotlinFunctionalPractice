package calculatorPractice

fun main(args: Array<String>) {
    val fpCalculator = Functional()

    println(fpCalculator.calculate({n1, n2 -> n1 + n2}, 3, 1)) // 4 출력
    println(fpCalculator.calculate({n1, n2 -> n1 - n2}, 3, 1)) // 2 출력
}

class Functional {
    fun calculate(
        calculator: (Int, Int) -> Int,
        num1: Int,
        num2: Int
    ): Int = calculator(num1, num2)
}