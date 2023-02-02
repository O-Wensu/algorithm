import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dq = ArrayDeque<Int>()
    repeat(readLine().toInt()){
        val command = readLine()
        when(command) {
            "size" -> bw.write("${dq.size}\n")
            "empty" -> if (dq.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "front" -> if (dq.isNotEmpty()) bw.write("${dq.first()}\n") else bw.write("-1\n")
            "back" -> if (dq.isNotEmpty()) bw.write("${dq.last()}\n") else bw.write("-1\n")
            else -> {
                val token = StringTokenizer(command, " ")
                when (token.nextToken()) {
                    "push_front" -> dq.addFirst(token.nextToken().toInt())
                    "push_back" -> dq.addLast(token.nextToken().toInt())
                    "pop_front" -> {
                        val num = dq.removeFirstOrNull() ?: -1
                        bw.write("${num}\n")
                    }
                    "pop_back" -> {
                        val num = dq.removeLastOrNull() ?: -1
                        bw.write("${num}\n")
                    }
                }
            }
        }
    }
    bw.flush()
    bw.close()
}