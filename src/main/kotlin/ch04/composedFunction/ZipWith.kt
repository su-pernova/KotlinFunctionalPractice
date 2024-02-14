package ch04.composedFunction

fun main(args: Array<String>) {
    fun <T> List<T>.head() = first()
    fun <T> List<T>.tail() = drop(1)

    tailrec fun <P1, P2, R> zipWith(func: (P1, P2) -> R, list1: List<P1>, list2: List<P2>, acc: List<R> = listOf()): List<R> = when {
        list1.isEmpty() || list2.isEmpty() -> acc
        else -> {
            val zipList = acc + listOf(func(list1.head(), list2.head()))
            zipWith(func, list1.tail(), list2.tail(), zipList)
        }
    }

    val list1 = listOf(6, 3, 2, 1, 4)
    val list2 = listOf(7, 4, 2, 6, 3)
    val add = { p1: Int, p2: Int -> p1 + p2 }

    val result1 = zipWith(add, list1, list2)
    println(result1)

    // 연습문제 4-7
    // 리스트의 값을 조건 함수에 적용했을 때 결괏값이 참인 리스트를 반환하는 takeWhile 함수를 꼬리 재귀로 작성하라.
    tailrec fun <P1> takeWhile(func: (P1) -> Boolean, list1: List<P1>, acc: List<P1> = listOf()): List<P1> = when {
        list1.isEmpty() -> acc
        else -> {
            var zipList = acc
            if (func(list1.head())) { zipList = zipList + list1.head() }
            takeWhile(func, list1.tail(), zipList)
        }
    }

    val myList = listOf(6, 3, 2, 1, 4)
    val above = { p1: Int -> p1 < 3 }
    val myResult = takeWhile(above, myList)
    println(myResult)

    // 연습문제 4-8
    // 무한대를 입력 받을 수 있는 takeWhile 을 꼬리 재귀로 작성해 보자.
    tailrec fun <P1> takeWhileInfinite(func: (P1) -> Boolean, sequence1: Sequence<P1>, acc: List<P1> = listOf()): List<P1> = when {
        !sequence1.iterator().hasNext() -> acc
        else -> {
            var zipList = acc
            if (func(sequence1.first())) {
                zipList = zipList + sequence1.first()
                takeWhileInfinite(func, sequence1.drop(1), zipList)
            }
            else takeWhileInfinite(func, sequenceOf(), zipList)
        }
    }

    val infiniteValue = generateSequence(1) { it + 1 }
    val infiniteResult = takeWhileInfinite(above, infiniteValue)
    println(infiniteResult)
}