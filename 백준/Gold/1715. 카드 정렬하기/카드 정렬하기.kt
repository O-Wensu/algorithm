import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q = PriorityQueue<Int>()
    var sum = 0

    repeat(readLine().toInt()) {
        q.add(readLine().toInt())
    }

    while(q.isNotEmpty()){
        if (q.size > 1) {
            val temp = q.remove() + q.remove()
            sum += temp
            q.add(temp)
        } else {
            q.remove()
            bw.write("${sum}\n")
        }
    }
    bw.flush()
    bw.close()
}