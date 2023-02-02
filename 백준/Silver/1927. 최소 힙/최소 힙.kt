import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val h = PriorityQueue<Int>()
    repeat(readLine().toInt()) {
        val input = readLine().toInt()
        if (input > 0) {
            h.add(input)
        } else {
            if (h.isEmpty()) bw.write("0\n")
            else bw.write("${h.remove()}\n")
        }
    }
    bw.flush()
    bw.close()
}