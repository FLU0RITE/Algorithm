import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    val line = StringTokenizer(readLine())
    var min = 1000000
    var max = -1000000
    while (line.hasMoreTokens()) {
        val each  = line.nextToken().toInt()
        if (each < min)
            min = each
        if (each > max)
            max = each
    }

    println("$min "+max)
}








