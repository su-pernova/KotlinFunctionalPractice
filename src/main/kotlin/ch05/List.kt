package ch05

sealed class FunList<out T> {
    object Nil: FunList<Nothing>()
    data class Cons<out T>(val head: T, val tail: FunList<T>) : FunList<T>()
}

fun <T> FunList<T>.addHead(head: T): FunList<T> = FunList.Cons(head, this)

fun <T> FunList<T>.unsafeAppendTail(value: T): FunList<T> = when (this) {
    is FunList.Nil -> FunList.Cons(value, FunList.Nil) // 재귀 종료 조건
    is FunList.Cons -> FunList.Cons(head, tail.unsafeAppendTail(value))
}

tailrec fun <T> FunList<T>.reverse(acc: FunList<T> = FunList.Nil): FunList<T> = when (this) {
    is FunList.Nil -> acc
    is FunList.Cons -> tail.reverse(acc.addHead(head))
}

tailrec fun <T> FunList<T>.safeAppendTail(value: T, acc: FunList<T> = FunList.Nil): FunList<T> = when (this) {
    is FunList.Nil -> FunList.Cons(value, acc).reverse() // 재귀 종료 조건
    is FunList.Cons -> tail.safeAppendTail(value, acc.addHead(head))
}

fun <T> FunList<T>.getTail(): FunList<T> = when (this) {
    FunList.Nil -> throw NoSuchElementException()
    is FunList.Cons -> tail
}

fun <T> FunList<T>.getHead(): T = when (this) {
    FunList.Nil -> throw NoSuchElementException()
    is FunList.Cons -> head
}

fun main(args: Array<String>) {
    val list: FunList<Int> = FunList.Cons(1, FunList.Cons(2, FunList.Nil))
    println(list)

    // 연습문제 5-1
    val intList: FunList<Int> = FunList.Cons(
        1, FunList.Cons(
            2, FunList.Cons(
                3, FunList.Cons(
                    4, FunList.Cons(5, FunList.Nil)
                )
            )
        )
    )
    println(intList)

    // 연습문제 5-2
    val doubleList: FunList<Double> = FunList.Cons(
        1.0, FunList.Cons(
            2.0, FunList.Cons(
                3.0, FunList.Cons(
                    4.0, FunList.Cons(5.0, FunList.Nil)
                )
            )
        )
    )
    println(doubleList)

    val addHeadList = list.addHead(0)
    println(addHeadList)

    val appendTailList = list.unsafeAppendTail(3)
    println(appendTailList)

    val safeAppendTailList = list.safeAppendTail(3)
    println(safeAppendTailList)

    println(safeAppendTailList.getTail())

    // 연습문제 5-3
    // 리스트의 첫 번째 값을 가져오는 getHead 함수를 작성해 보자.
    println(list.getHead())
}