import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val queue : Queue<Int> = LinkedList()
    repeat(readLine().toInt()) {
        when(val line = readLine()) {
            "pop" -> if (queue.isEmpty()) bw.write(("-1\n")) else bw.write(queue.remove().toString() + "\n")
            "size" -> bw.write(queue.size.toString() + "\n")
            "empty" -> if(queue.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "front" -> if (queue.isEmpty()) bw.write("-1\n") else bw.write(queue.first().toString() + "\n")
            "back" -> if (queue.isEmpty()) bw.write("-1\n") else bw.write(queue.last().toString() + "\n")
            else -> {
                val token = StringTokenizer(line)
                token.nextToken()
                queue.add(token.nextToken().toInt())
            }
        }
    }
    bw.flush()
    bw.close()
}