import kotlin.math.*
class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        
        val graph = Array(n+1) {mutableListOf<Int>()}
        for (wire in wires) {
            graph[wire[0]].add(wire[1])
            graph[wire[1]].add(wire[0])
        }
        var ans = Int.MAX_VALUE
        val check = Array(n+1){false}
        fun dfs(c:Int) {
            check[c] = true
            for (i in graph[c]) {
                if (!check[i]) {
                    dfs(i)
                }
            }
        }
        fun cal(a:Int,b:Int) {
            dfs(a)
            val first = check.count{it}
            dfs(b)
            val second = check.count{it} - first
            ans = minOf(ans, abs(first-second))
            for (i in check.indices) check[i] = false
        }
        for (wire in wires) {
            val a = wire[0]
            val b = wire[1]
            graph[a].remove(b)
            graph[b].remove(a)
            cal(a,b)
            graph[a].add(b)
            graph[b].add(a)
        }
        
        return ans
    }
}