import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val map = mutableMapOf<Int,Int>()
    val n = readLine().toInt()
    val token = StringTokenizer(readLine())
    val m = readLine().toInt()
    val token2 = StringTokenizer(readLine())

    repeat(n) {
        val k = token.nextToken().toInt()
        if (map.containsKey(k)){
            map[k] = map[k]!! + 1
        } else {
            map[k] = 1
        }
    }

    repeat(m) {
        val k = token2.nextToken().toInt()
        if (map.containsKey(k)) {
            bw.write("${map[k]} ")
        } else {
            bw.write(("0 "))
        }
    }

    bw.flush()
    bw.close()
}