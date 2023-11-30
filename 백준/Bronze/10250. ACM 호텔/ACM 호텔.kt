import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    repeat(repeatNum) {
        val line = StringTokenizer(readLine())
        val h = line.nextToken().toInt()
        val w = line.nextToken().toInt()
        val n = line.nextToken().toInt()
        if (n%h == 0)
            println(h * 100 + n / h)
        else
            println(n % h * 100 + n / h + 1)
    }
}








