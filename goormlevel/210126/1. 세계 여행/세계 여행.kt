import java.util.Scanner
import kotlin.math.max

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val nodeNum = sc.nextInt()
    val edgeNum = sc.nextInt()
    val language = mutableListOf<Int>()
    val graph = Array(nodeNum + 1) { mutableListOf<Int>() }
    language.add(0)
    repeat(nodeNum) {
        language.add(sc.nextInt())
    }
    repeat(edgeNum) {
        val first = sc.nextInt()
        val second = sc.nextInt()
        graph[first].add(second)
        graph[second].add(first)
    }
    val search = language.toMutableSet()
    search.remove(0)

    var maxGroupSize = 0
    for (each in search) {
        val isVisited = MutableList(nodeNum + 1) { false }
        maxGroupSize = max(dfs(1, each, graph, language, isVisited), maxGroupSize)
    }
    println(maxGroupSize)
}

fun dfs(i: Int, c: Int, g: Array<MutableList<Int>>, l: MutableList<Int>, v: MutableList<Boolean>): Int {
    v[i] = true
    var total = 0
    for (index in g[i]) {
        if (!v[index] && (l[index] == c || l[index] == l[1])) {
            total += dfs(index, c, g, l, v)
        }
    }
    return total + 1
}
