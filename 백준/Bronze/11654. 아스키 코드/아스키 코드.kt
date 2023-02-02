import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    var ch = (readLine().toCharArray())[0]
    print("${ch.toInt()}")
}