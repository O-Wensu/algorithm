import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val token = StringTokenizer(readLine())
    val n = token.nextToken().toInt() + token.nextToken().toInt()
    val map = mutableMapOf<String, Int>()

    repeat(n) {
        val name = readLine()
        if (map.containsKey(name)) {
            map[name] = map[name]!! + 1
        } else {
            map[name] = 1
        }
    }
    val new_map = map.filterValues { it == 2 }.toSortedMap()

    bw.write("${new_map.size}\n")

    for (entry in new_map) {
        bw.write("${entry.key}\n")
    }

    bw.flush()
    bw.close()
}
