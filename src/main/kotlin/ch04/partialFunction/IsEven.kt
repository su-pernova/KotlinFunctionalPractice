package ch04.partialFunction

fun main(args: Array<String>) {
    val isEven = PartialFunc<Int, String>({ it % 2 == 0 }, { "$it is even" })

    if (isEven.isDefinedAt(100)) println(isEven(100))
    else println("isDefinedAt(x) return false")
    isEven.invoke(100)

    println("- - - - - - - - - - - - - - - - -")

    if (isEven.isDefinedAt(101)) println(isEven(101))
    else println("isDefinedAt(x) return false")
    // isEven.invoke(101) // IllegalArgumentException 발생

    println("- - - - - - - - - - - - - - - - -")

    print("invokeOrElse : ")
    val notEvenNumber = 7
    println(isEven.invokeOrElse(notEvenNumber, "$notEvenNumber is not even."))

    print("orElse : ")
    val isNotEven = PartialFunc<Int, String>({ it % 2 != 0 }, { "$it is not even" })
    println(isEven.orElse(notEvenNumber, isNotEven).invoke(notEvenNumber))
}