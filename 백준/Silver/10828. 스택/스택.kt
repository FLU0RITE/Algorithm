import java.util.Stack
import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    val bar = Stack<Int>()
    repeat(repeatNum) {
        val eachLine = StringTokenizer(readLine())
        val command = eachLine.nextToken()
        if (command == "push") {
            bar.push(eachLine.nextToken().toInt())
        } else if (command == "top") {
            if (bar.empty()) {
                println(-1)
            } else {
                println(bar.peek())
            }

        } else if (command == "size") {
            println(bar.size)
        } else if (command == "empty") {
            if (bar.empty()) {
                println(1)
            } else {
                println(0)
            }
        } else if (command == "pop"){
            if (bar.empty()) {
                println(-1)
            } else {
                println(bar.pop())
            }
        }
    }
}

