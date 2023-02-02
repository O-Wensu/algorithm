import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var stack = Stack<Int>()
    repeat(br.readLine().toInt()) {
        val num = br.readLine().toInt()
        if(num == 0) {
            stack.pop()
        } else {
            stack.push(num)
        }
    }
    val sum = stack.sum()
    bw.write(sum.toString())
    bw.flush()
    bw.close()
}