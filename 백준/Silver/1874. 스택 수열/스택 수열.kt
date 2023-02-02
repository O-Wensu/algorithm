import java.io.*
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    val stack = Stack<Int>()
    val size = br.readLine().toInt()
    var num = mutableListOf<Int>()

    repeat(size) {
        num.add(br.readLine().toInt())
    }

    for (i in 1..size) {
        stack.push(i)
        stringBuilder.append("+\n")
        while(true) {
            if (stack.size > 0) {
                if (stack.peek() == num[0]) {
                    stack.pop()
                    if (num.isNotEmpty()) {
                        num.removeAt(0)
                    }
                    stringBuilder.append("-\n")
                } else if (stack.peek() > num[0]) {
                    println("NO")
                    return
                } else {
                    break
                }
            } else break
        }
    }
    print(stringBuilder)
}