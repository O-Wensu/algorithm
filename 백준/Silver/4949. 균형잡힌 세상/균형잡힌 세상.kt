import java.util.*
import java.io.*
import java.util.Stack

/*
백준 4949번
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    loop@ while(true) {
        val line = br.readLine()
        if (line == ".") break
        val token = StringTokenizer(line, ".")
        for (t in token) {
            val str = t.toString()
            val stack = Stack<Char>()
            if (str.contains("(") || str.contains("[")
                || str.contains(")") || str.contains("]")
            ) {
                for (s in str) {
                    when (s) {
                        '(', '[' -> stack.push(s)
                        ')' -> {
                            if (!stack.isEmpty() && stack.peek() == '(') stack.pop()
                            else {
                                bw.write("no\n")
                                continue@loop
                            }
                        }
                        ']' -> {
                            if (!stack.isEmpty() && stack.peek() == '[') stack.pop()
                            else {
                                bw.write("no\n")
                                continue@loop
                            }
                        }
                    }
                }
            }
            bw.write(if (stack.isEmpty()) "yes\n" else "no\n")
        }
    }
    bw.flush()
    bw.close()
}