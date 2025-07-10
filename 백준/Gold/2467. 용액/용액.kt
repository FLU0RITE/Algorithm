import java.io.*
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.absoluteValue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = n-1
    var min = 2000000000
    var startMin = 0
    var endMin = 0
    while(start < end) {
        val sum = arr[start] + arr[end]
        if (sum.absoluteValue < min.absoluteValue) {
            min = sum
            startMin = start
            endMin = end
        }
        val forwardStart = arr[start+1] + arr[end]
        val backwardEnd = arr[end-1] + arr[start]
        if (forwardStart.absoluteValue < backwardEnd.absoluteValue) {
            start += 1
        } else {
            end -= 1
        }
    }

    bw.write(arr[startMin].toString() + " " + arr[endMin].toString())
    bw.flush()
}
