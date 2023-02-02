import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(readLine().toInt()){
        val num = readLine().toInt()
        if (num != 0) {
            q.add(num)
        } else {
            if (q.isEmpty()) bw.write("0\n")
            else bw.write("${q.remove()}\n")
        }
    }
    bw.flush()
    bw.close()
}