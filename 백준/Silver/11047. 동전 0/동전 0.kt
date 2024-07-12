import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var k = sc.nextInt()
    val coin = mutableListOf<Int>()
    repeat(n){
        coin.add(sc.nextInt())
    }
    var total = 0
    while (k!=0){
        for (i in n-1 downTo 0){
            if (k - coin[i] >= 0){
                k -= coin[i]
                total+=1
                break
            }
        }
    }
    println(total)
}

