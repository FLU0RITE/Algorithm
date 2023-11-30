import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val b = readLine()
    var a = readLine().toInt()
    var index = 1
    for (i in b){
        if (index == a)
            println(i)
        index++
    }
}








