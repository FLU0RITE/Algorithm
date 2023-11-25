import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input: String = readLine()
    val answer = StringTokenizer(input)
    println(answer.nextToken().toInt() - answer.nextToken().toInt())
}








