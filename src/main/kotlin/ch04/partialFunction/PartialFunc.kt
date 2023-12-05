package ch04.partialFunction

// 생성자는 두개의 함수를 매개변수로 받는다
    // condition : 입력값의 조건을 확인하는 함수
    // f : 입력값이 조건에 맞으면 실행되는 함수
class PartialFunc<P, R>(
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
) : (P) -> R {
    override fun invoke(p: P): R = when {
        condition(p) -> f(p)
        else -> throw IllegalArgumentException("$p is not supported.")
    }

    fun isDefinedAt(p: P): Boolean = condition(p)

    // 연습문제 4-1
        // 입력값 p가 조건에 맞지 않을 때 기본값 default 를 반환한다.
    fun invokeOrElse(p: P, default: R): R = when {
        condition(p) -> f(p)
        else -> default
    }

    // 연습문제 4-1
        // PartialFunction 의 입력값 p가 조건에 맞으면 PartialFunction 을 그대로 반환하고, 조건에 맞지 않으면 that 을 반환한다.
        // 책에서는 매개변수 (p : P) 가 함수 프로토타입에서 빠져있음 (오타인듯)
    fun orElse(p : P, that : PartialFunc<P,R>) : PartialFunc<P,R> = when {
        this.isDefinedAt(p) -> this
        else -> that
    }
}
