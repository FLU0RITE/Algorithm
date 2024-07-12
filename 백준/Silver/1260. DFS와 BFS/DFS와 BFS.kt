import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val nodeNum = sc.nextInt()
    val edgeNum = sc.nextInt()
    val startNode = sc.nextInt()
    val g = Array(nodeNum+1){ mutableListOf<Int>() }
    repeat(edgeNum){
        val first = sc.nextInt()
        val second = sc.nextInt()
        g[first].add(second)
        g[first].sort()
        g[second].add(first)
        g[second].sort()
    }
    var v = Array(nodeNum+1){false}
    dfs(startNode,g, v)
    println()
    v = Array(nodeNum+1){false}
    val queue = LinkedList<Int>()
    queue.add(startNode)
    v[startNode] = true
    bfs(g, v,queue)
}

fun dfs(c:Int,g:Array<MutableList<Int>>,v:Array<Boolean>){
    print("$c ")
    v[c] = true
    for (each in g[c]){
        if (!v[each]){
            dfs(each,g,v)
        }
    }
}

fun bfs(g:Array<MutableList<Int>>,v:Array<Boolean>,queue: LinkedList<Int>){
    if (queue.isEmpty())
        return
    val c = queue.poll()
    print("$c ")


    for (each in g[c]){
        if (!v[each]){
            v[each] = true
            queue.add(each)
        }

    }
    bfs(g,v,queue)
}