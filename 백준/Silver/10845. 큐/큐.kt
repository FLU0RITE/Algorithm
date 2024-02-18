import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    val bar: Queue<Int> = LinkedList()
    var last = -1
    repeat(repeatNum) {
        val eachLine = StringTokenizer(readLine())
        val command = eachLine.nextToken()
        if (command == "push") {
            last = eachLine.nextToken().toInt()
            bar.offer(last)
        } else if (command == "front") {
            if (bar.isEmpty()) {
                println(-1)
            } else {
                println(bar.peek())
            }
        } else if (command == "back") {
            if (bar.isEmpty()) {
                println(-1)
            } else {
                println(last)
            }
        } else if (command == "size") {
            println(bar.size)
        } else if (command == "empty") {
            if (bar.isEmpty()) {
                println(1)
            } else {
                println(0)
            }
        } else if (command == "pop") {
            if (bar.isEmpty()) {
                println(-1)
            } else {
                println(bar.remove())
            }
        }
    }
}

