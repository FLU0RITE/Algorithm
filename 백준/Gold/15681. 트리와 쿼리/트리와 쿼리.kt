import java.io.*
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.absoluteValue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,r,q) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1) { mutableListOf<Int>() }
    val tree = Array(n+1) { Array(2){mutableListOf<Int>() }}
    val subtreeSize = Array(n+1){ 1 }
    repeat(n-1) {
        val (s,e) = br.readLine().split(" ").map { it.toInt() }
        graph[s].add(e)
        graph[e].add(s)
    }
    fun makeTree(currentNode:Int, parent:Int) {
        for (node in graph[currentNode]) {
            if (node != parent) {
                tree[currentNode][1].add(node)
                tree[currentNode][0].add(node)
                makeTree(node, currentNode)
            }
        }
    }
    makeTree(r,-1)
    fun countSubtreeNodes(currentNode:Int){
        for (node in tree[currentNode][1]) {
            countSubtreeNodes(node)
            subtreeSize[currentNode] += subtreeSize[node]
        }
    }
    countSubtreeNodes(r)
    repeat(q){
        val query = br.readLine().toInt()
        bw.write(subtreeSize[query].toString() + "\n")
    }
    bw.flush()
}

