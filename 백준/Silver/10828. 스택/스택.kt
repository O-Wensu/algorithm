package baekjoon

/*
백준 10826번
 */

class Stack {
    var stack = mutableListOf<Int>()

    fun push(number: Int) {
        stack.add(number)
    }

    fun top(): Int {
        if (stack.isEmpty())
            return -1
        return stack.last()
    }

    fun size(): Int {
        return stack.size
    }

    fun empty(): Int {
        if (stack.isEmpty())
            return 1
        return 0
    }

    fun pop(): Int {
        if (stack.isEmpty())
            return -1
        return stack.removeLast()
    }
}

fun main(args: Array<String>) {
    val size = readLine()!!.toInt()
    val stack = Stack()
    for (i in 0 until size) {
        val command = readLine()!!.split(" ")
        when(command[0]) {
            "push" -> stack.push(command[1].toInt())
            "top" -> println(stack.top())
            "size" -> println(stack.size())
            "empty" -> println(stack.empty())
            "pop" -> println(stack.pop())
        }
    }
}