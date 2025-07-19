import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(v + 1) { mutableListOf<Pair<Int, Int>>() }
    val visited = BooleanArray(v + 1) { false }

    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // 최소 가중치 기준 우선순위 큐
    var sum = 0

    pq.add(Pair(1, 0)) // 시작 노드(가중치 0)

    while (pq.isNotEmpty()) {
        val (cur, cost) = pq.poll()

        if (visited[cur]) continue
        visited[cur] = true
        sum += cost

        for (next in graph[cur]) {
            if (!visited[next.first]) {
                pq.add(next)
            }
        }
    }

    bw.write("$sum\n")
    bw.flush()
}
