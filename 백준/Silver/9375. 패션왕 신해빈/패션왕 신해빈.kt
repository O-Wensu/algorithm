import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        val map = mutableMapOf<String, Int>()
        repeat(readLine().toInt()) {
            val token = StringTokenizer(readLine())
            token.nextToken()
            val item = token.nextToken()
            map[item] = if (map.containsKey(item)) map[item]!! + 1 else 1
        }
        var result = 1
        map.values.forEach {
            result *= (it + 1)
        }
        result--
        bw.write("${result}\n")
    }
    bw.flush()
    bw.close()
}