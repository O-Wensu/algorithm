import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q: Queue<Int> = LinkedList()
    repeat(readLine().toInt()) {
        val command = readLine()
        when(command) {
            "front" -> if (q.isNotEmpty()) bw.write("${q.first()}\n") else bw.write("-1\n")
            "back" -> if (q.isNotEmpty()) bw.write("${q.last()}\n") else bw.write("-1\n")
            "size" -> bw.write("${q.size}\n")
            "empty" -> if (q.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "pop" -> if (q.isNotEmpty()) bw.write("${q.remove()}\n") else bw.write("-1\n")
            else -> {
                val token = StringTokenizer(command)
                token.nextToken()
                q.add(token.nextToken().toInt())
            }
        }
    }
    bw.flush()
    bw.close()
}