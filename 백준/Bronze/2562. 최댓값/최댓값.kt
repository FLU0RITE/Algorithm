import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var max = 0
    var maxIndex = 0
    var index = 1
    repeat(9){
        val h = readLine().toInt()
        if (max < h){
            max = h
            maxIndex = index
        }
        index++
    }
    println(max)
    println(maxIndex)
    
}








