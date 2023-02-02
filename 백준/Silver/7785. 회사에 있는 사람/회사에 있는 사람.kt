import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = mutableSetOf<String>()
    repeat(readLine().toInt()) {
        val token = StringTokenizer(readLine())
        val name = token.nextToken()
        if (s.contains(name)){
            s.remove(name)
        } else s.add(name)
        
    }
    val ss = s.sortedDescending()
    ss.forEach{
        bw.write("${it}\n")
    }
    bw.flush()
    bw.close()
}