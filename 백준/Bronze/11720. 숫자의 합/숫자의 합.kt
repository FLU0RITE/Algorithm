import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var a = readLine().toInt()
    val b = readLine().toString()
    a = 0
    for (i in b){
        a += i.code-48
    }
    println(a)
}








