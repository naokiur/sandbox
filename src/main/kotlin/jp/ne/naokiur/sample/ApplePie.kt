package jp.ne.naokiur.sample

fun main(args: Array<String>) {
    main(1, 3)
}
fun main(A: Int, P: Int): Int {
    val pieces = A * 3 + P
    return pieces.div(2)
}