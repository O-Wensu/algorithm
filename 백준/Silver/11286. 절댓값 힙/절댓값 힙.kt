import java.io.*
import java.util.*
import kotlin.math.absoluteValue

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var lambda = {a: Int, b: Int -> when {
        a > b -> 1
        a < b -> -1
        else -> 0
    }}
    val q = PriorityQueue<Pair<Int, Int>> { a, b ->
        when (a.second) {
            b.second -> lambda(a.first, b.first)
            else -> lambda(a.second, b.second)
        }
    }
    repeat(readLine().toInt()) {
        val num = readLine().toInt()
        if (num != 0) {
            q.add(Pair(num, num.absoluteValue))
        } else {
            if (q.isEmpty()) bw.write("0\n")
            else {
                bw.write("${q.remove().first}\n")
            }
        }
    }
    bw.flush()
    bw.close()
}