import java.util.LinkedList
import java.util.Queue
import java.util.Scanner
import java.util.Stack
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val rgb = Array(n) { mutableListOf<Int>() }
    val acc = Array(n) { arrayOf(0,0,0) }
    var ans = 0

        for (i in 0 until n) {

        rgb[i].add(sc.nextInt())
        rgb[i].add(sc.nextInt())
        rgb[i].add(sc.nextInt())
    }
    acc[0][0] = rgb[0][0]
    acc[0][1] = rgb[0][1]
    acc[0][2] = rgb[0][2]
    for (index in 1..<n){
        acc[index][0] = min(acc[index-1][1],acc[index-1][2])+rgb[index][0]
        acc[index][1] = min(acc[index-1][0],acc[index-1][2])+rgb[index][1]
        acc[index][2] = min(acc[index-1][0],acc[index-1][1])+rgb[index][2]
    }
    ans = min(acc[n-1][0],acc[n-1][1])
    ans = min(acc[n-1][2],ans)
    println(ans)
}

