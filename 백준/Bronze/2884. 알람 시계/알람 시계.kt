import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = StringTokenizer(readLine())
    val h = line.nextToken().toInt()
    val m = line.nextToken().toInt()
    if (m < 45) {
        if (h == 0) {
            println("${23} ${60 + m - 45}")
        } else {
            println("${h - 1} ${60 + m - 45}")
        }
    } else {
        println("${h} ${m - 45}")
    }
}








