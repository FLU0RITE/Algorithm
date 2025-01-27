import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val board = Array(n) { Array(n) { 100000000 } }

    repeat(m) {
        val (s, e, w) = br.readLine().split(" ").map { it.toInt() }
        if (board[s - 1][e - 1] > w)
            board[s - 1][e - 1] = w
    }
    for (i in board.indices) {
        board[i][i] = -1
    }
    val (current, end) = br.readLine().split(" ").map { it.toInt() }
    br.close()
    val distances = Array(n) { 100000000 }
    dijkstra(board, current - 1, end - 1,distances)
}

fun dijkstra(board: Array<Array<Int>>, c: Int, e: Int,distances: Array<Int>) {
    val pq = PriorityQueue<Pair<Int, Int>>({ a, b -> a.second - b.second })

    distances[c] = 0
    pq.add(Pair(c, 0))

    while (pq.isNotEmpty()) {
        val current = pq.peek().first
        val cost = pq.peek().second

        pq.poll()

        if (cost > distances[current]) {
            continue
        }

        for (i in board.indices) {
            if (board[current][i] != -1 && distances[i] > distances[current] + board[current][i]) {
                distances[i] = distances[current] + board[current][i]
                pq.add(Pair(i, distances[i]))
            }
        }
    }
    println(distances[e])
}
