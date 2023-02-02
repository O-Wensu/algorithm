import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val lectures = Array(readLine().toInt()) {
        val token = StringTokenizer(readLine())
        val start = token.nextToken().toInt()
        val end = token.nextToken().toInt()
        listOf(start, end)
    }.sortedArrayWith() { a, b -> a.first() - b.first()  }

    val pq = PriorityQueue<Int>()

    var count = 0
    lateinit var prev: Pair<Int,Int>

    for (lec in lectures) {
        if (pq.isEmpty())  {
            pq.offer(lec[1])
        } else {
            if (pq.peek() <= lec[0]) {
                pq.poll()
                pq.offer(lec[1])
            } else {
                pq.offer(lec[1])
            }
        }
    }
    println(pq.size)
}