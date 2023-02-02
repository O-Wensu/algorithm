import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        val token = StringTokenizer(readLine())
        bw.write("${token.nextToken().toInt() + token.nextToken().toInt()}\n")
    }
    bw.flush()
    bw.close()
}