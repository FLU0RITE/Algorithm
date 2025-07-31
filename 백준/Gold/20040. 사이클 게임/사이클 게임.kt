import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n) { it }
    var answer = 0

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(a: Int, b: Int): Boolean {
        val rootA = find(a)
        val rootB = find(b)
        if (rootA == rootB) return false
        parent[rootB] = rootA
        return true
    }

    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        if (!union(a, b)) {
            answer = i
            break
        }
    }

    bw.write("$answer\n")
    bw.flush()
}
