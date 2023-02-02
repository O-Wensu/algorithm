import java.util.Stack

fun main(args: Array<String>) {
    val size = readLine()!!.toInt()
    for (i in 0 until size) {
        val line = readLine()
        val stack = Stack<Char>()
        var ans = "YES"
        line?.let {
            for (c in line) {
                if (c == '(') stack.push(c)
                else {
                    if (stack.size > 0 && stack.peek() == '(') stack.pop()
                    else ans = "NO"
                }
            }
        }
        if (stack.size > 0) ans = "NO"
        println(ans)
    }
}