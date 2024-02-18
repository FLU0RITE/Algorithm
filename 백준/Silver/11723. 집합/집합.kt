import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val read = BufferedReader(InputStreamReader(System.`in`))
    val write = BufferedWriter(OutputStreamWriter(System.out))
    var bar = mutableSetOf<Int>()
    repeat(read.readLine().toInt()) {
        val eachLine = StringTokenizer(read.readLine())
        val command = eachLine.nextToken()
        if (command == "add") {
            bar.add(eachLine.nextToken().toInt())
        } else if (command == "check") {
            if (bar.contains(eachLine.nextToken().toInt())) {
                write.write("1\n")
            } else {
                write.write("0\n")
            }
        } else if (command == "empty") {
            bar = mutableSetOf<Int>()
        } else if (command == "remove") {
            bar.remove(eachLine.nextToken().toInt())
        } else if (command == "toggle") {
            val num = eachLine.nextToken().toInt()
            if (bar.contains(num)) {
                bar.remove(num)
            } else {
                bar.add(num)
            }
        } else if (command == "all") {
            bar = mutableSetOf<Int>()
            for (i in 1..20) {
                bar.add(i)
            }
        }
    }
    write.flush()
    write.close()
}

