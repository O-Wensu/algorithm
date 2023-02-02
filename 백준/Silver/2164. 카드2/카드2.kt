import java.io.*
import java.util.*
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val q: Queue<Int> = LinkedList()
    for (i in 1..n) q.add(i)
    while(q.size != 1) {
        q.remove()
        q.add(q.remove())
    }
    println(q.first())
}