import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var kg = readLine().toInt()
    var count = 0

    while (true) {
        if (kg % 5 == 0) {
            if (kg == 0) println(count)
            else println("${count + kg / 5}")
            break
        } else if (kg < 0) {
            println("-1")
            break
        }
        kg -= 3
        count += 1
    }
}
