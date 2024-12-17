import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (input, output) = br.readLine().split(" ").map { it.toLong() }

    println(bfs(input, output))
}

fun bfs(input: Long, output: Long): Int {
    val queue: Queue<Pair<Long, Int>> = LinkedList()
    queue.add(Pair(input, 1))

    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()

        if (current == output) {
            return count
        }

        if (current * 2 <= output) {
            queue.add(Pair(current * 2, count + 1))
        }
        if (current * 10 + 1 <= output) {
            queue.add(Pair(current * 10 + 1, count + 1))
        }
    }

    return -1
}
