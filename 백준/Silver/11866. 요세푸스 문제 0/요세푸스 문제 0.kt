import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)){
    val (N, K) = Pair(nextInt(), nextInt())
    var ls = (1..N).toMutableList()
    var pos = 0
    val ans = mutableListOf<Int>()
    for (i in 0 until N) {
        pos += K - 1
        pos %= ls.size
        ans.add(ls.removeAt(pos))
    }
    println(ans.joinToString(prefix = "<", separator = ", ", postfix = ">"))
}