import java.io.*
import java.util.Stack

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split("")
    val stack = Stack<Char>()
    var sum = 0

    for (i in line.indices) {
        if (line[i] == "(") stack.push('(')
        else if (line[i] == ")"){
            stack.pop()
            sum += if (line[i-1] == "(") {
                stack.size
            } else {
                1
            }
        }
    }
    println(sum)
}