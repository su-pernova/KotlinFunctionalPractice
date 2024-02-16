package ch05

fun main(args: Array<String>) {
    fun imperativeFilter(numList: List<Int>): List<Int> {
        val newList = mutableListOf<Int>()
        for (num in numList) {
            if (num % 2 == 0) newList.add(num)
        }
        return newList
    }

    fun functionalFilter(numList: List<Int>): List<Int> =
        numList.filter { it % 2 == 0 }

    val intList = listOf(1, 2, 3, 4, 5)
    println(imperativeFilter(intList))
    println(functionalFilter(intList))

    tailrec fun <T> FunList<T>.filter(
        acc: FunList<T> = FunList.Nil,
        p: (T) -> Boolean
    ): FunList<T> = when (this) {
        is FunList.Nil -> acc.reverse()
        is FunList.Cons ->
            if(p(head)) tail.filter (acc.addHead(head), p)
            else tail.filter(acc, p)

    }
    val intFunList: FunList<Int> = FunList.Cons(
        1, FunList.Cons(
            2, FunList.Cons(
                3, FunList.Cons(
                    4, FunList.Cons(5, FunList.Nil)
                )
            )
        )
    )
    val above = { p1: Int -> p1 < 3 }
    val filteredList = intFunList.filter(p = above)
    println(filteredList)

    // 연습문제 5-4
    // 주어진 리스트에서 앞의 값이 n개 제외된 리스트를 반환하는 drop 함수를 구현하라.
    // 이 때 원본 리스트가 바뀌지 않아야 하고, 새로운 리스트를 반환할 때마다 리스트를 생성하면 안 된다.
    tailrec fun <T> FunList<T>.myDrop(n: Int): FunList<T> = when (n) {
        0 -> this
        else -> this.getTail().myDrop(n - 1)
    }
    val droppedList = intFunList.myDrop(3)
    println(droppedList)

    // 연습문제 5-5
    // 타입 T 를 입력 받아 Boolean 을 반환하는 함수 p 를 입력 받는다.
    // 리스트의 앞에서부터 함수 p 를 만족하기 전까지 drop 을 하고, 나머지 값들의 리스트를 반환하는 함수를 구현하라.
    // 이 때 원본 리스트가 바뀌지 않아야 하고, 새로운 리스트를 반환할 때마다 리스트를 생성하면 안 된다.


    // 연습문제 5-6

    // 연습문제 5-7

}