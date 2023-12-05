package ch04.higherOrderFunction

fun main(args: Array<String>) {
    val higherOrderFunction = HigherOrderFunction()
    higherOrderFunction.func1 { println("Hello, Kotlin") }
    higherOrderFunction.func2().invoke()
}

class HigherOrderFunction {
    // 매개변수로 함수를 전달받는다.
    // 반환 타입이 Unit 인 함수를 매개변수로 받고 있음
    fun func1(func: () -> Unit): Unit {
        func()
    }

    // 함수를 반환한다.
    // 함수의 반환 타입이 '반환 타입이 Unit 인 함수'로 지정되어 있음
    fun func2(): () -> Unit {
        return { println("Hello, Kotlin") }
    }
}