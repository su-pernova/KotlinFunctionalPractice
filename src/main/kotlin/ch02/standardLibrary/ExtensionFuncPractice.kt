package ch02.standardLibrary

fun String.hello(): String {
    return "Hello, $this"
}

fun main() {
    println("World".hello())
    println("Kotlin".hello())
}