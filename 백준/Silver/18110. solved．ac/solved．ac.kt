import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    val opinion = mutableListOf<Int>()
    repeat(repeatNum) {
        opinion.add(readLine().toInt())
    }
    val opinionSorted = opinion.sorted()
    val exceptNum = (repeatNum*0.15 + 0.5).toInt()
    var level = 0
    for (i in exceptNum..<repeatNum-exceptNum){
        level += opinionSorted[i]
    }
    println(((level.toDouble()/(repeatNum-exceptNum*2))+0.5).toInt())
}

