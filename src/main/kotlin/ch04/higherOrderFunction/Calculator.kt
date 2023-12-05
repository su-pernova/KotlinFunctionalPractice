package ch04.higherOrderFunction

fun main(args: Array<String>) {
    val sum = Sum()
    val minus = Minus()
    val product = Product()

    println("sum : ${sum.calc(10, 5)}")
    println("minus : ${minus.calc(10, 5)}")
    println("product : ${product.calc(10, 5)}")
}

interface Calculator {
    fun calc(x: Int, y: Int): Int
}

class Sum: Calculator {
    // override fun calc(x: Int, y: Int): Int { ... } 형태의 보일러플레이트 코드가 반복된다.
    override fun calc(x: Int, y: Int): Int {
        return x + y
    }
}

class Minus: Calculator {
    override fun calc(x: Int, y: Int): Int {
        return x - y
    }
}

class Product: Calculator {
    override fun calc(x: Int, y: Int): Int {
        return x * y
    }
}
