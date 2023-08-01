package ch01

fun main(args: Array<String>) {
    val plusCalculator = ObjectOriented(Plus())
    println(plusCalculator.calculate(3, 1)) // 4 출력

    val minusCalculator = ObjectOriented(Minus())
    println(minusCalculator.calculate(3, 1)) // 2 출력
}

interface Calculator {
    fun calculate(num1: Int, num2: Int): Int
}

class Plus : Calculator {
    override fun calculate(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

class Minus : Calculator {
    override fun calculate(num1: Int, num2: Int): Int {
        return num1 - num2
    }
}

class ObjectOriented(private val calculator: Calculator) {
    fun calculate(num1: Int, num2: Int): Int = calculator.calculate(num1, num2)
}