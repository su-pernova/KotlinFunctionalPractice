package ch04.higherOrderFunction

fun main(args: Array<String>) {
    // 비즈니스 로직을 모아볼 수 있어 가독성이 좋다.
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val minus: (Int, Int) -> Int = { x, y -> x - y }
    val product: (Int, Int) -> Int = { x, y -> x * y }

    println("sum : ${sum(10, 5)}")
    println("minus : ${minus(10, 5)}")
    println("product : ${product(10, 5)}\n")

    // 비즈니스 로직(sum, minus, product)을 주입받을 수 있다.
    println("sum : ${higherOrder(sum, 10, 5)}")
    println("minus : ${higherOrder(minus, 10, 5)}")
    println("product : ${higherOrder(product, 10, 5)}")
}

// 함수를 매개변수로 받는 고차함수
fun higherOrder(
    func: (Int, Int) -> Int,
    x: Int,
    y: Int
): Int = func(x,y)
