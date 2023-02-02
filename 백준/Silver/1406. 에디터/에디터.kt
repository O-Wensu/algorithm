import java.io.*
import java.util.*
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val lStack = Stack<Char>()
    val rStack = Stack<Char>()
    readLine().forEach { lStack.add(it) }
    repeat(readLine().toInt()) {
        val command = readLine()
        when(command) {
            "L" -> if (lStack.isNotEmpty()) rStack.push(lStack.pop())
            "D" -> if (rStack.isNotEmpty()) lStack.push(rStack.pop())
            "B" -> if (lStack.isNotEmpty()) lStack.pop()
            else -> {
                val token = StringTokenizer(command)
                token.nextToken()
                lStack.push(token.nextToken().single())
            }
        }
    }
    while(lStack.isNotEmpty()) {
        rStack.push(lStack.pop())
    }
    while(rStack.isNotEmpty()) {
            bw.write(rStack.pop().toString())
        }
    bw.flush()
    bw.close()
}