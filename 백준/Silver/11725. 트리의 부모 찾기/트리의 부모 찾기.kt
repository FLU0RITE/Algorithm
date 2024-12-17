import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt() 
    val graph = Array(n + 1) { mutableListOf<Int>() } 
    val parent = IntArray(n + 1) 


    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }


    dfs(graph, parent, 1, -1)


    val result = StringBuilder()
    for (i in 2..n) {
        result.append("${parent[i]}\n")
    }
    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun dfs(graph: Array<MutableList<Int>>, parent: IntArray, current: Int, prev: Int) {
    for (next in graph[current]) {
        if (next != prev) { 
            parent[next] = current 
            dfs(graph, parent, next, current) 
        }
    }
}
