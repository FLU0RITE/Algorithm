import java.util.Scanner
import kotlin.math.max

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val total = sc.nextInt()
    var size = mutableListOf<Int>()
    repeat(6){
        size.add(sc.nextInt())
    }
    val t = sc.nextInt()
    val p = sc.nextInt()
    var tT = 0
    for (each in size){
        tT += each/t
        if (each%t!=0)
            tT+=1
    }
    println(tT)
    print("${total/p} ${total%p}")

}

