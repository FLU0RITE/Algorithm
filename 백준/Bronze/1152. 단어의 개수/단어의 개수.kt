import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = StringTokenizer(readLine())
    var count = 0
    while (line.hasMoreTokens()){
        val each = line.nextToken()
        count++

    }
    println(count)
}








