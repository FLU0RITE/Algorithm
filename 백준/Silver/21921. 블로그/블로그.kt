import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    var max = 0
    var count = 0
    val arr = br.readLine().split(" ").map { it.toInt() }
    var cur = 0
    for (i in 0..<x) {
        cur += arr[i]
    }
    max = cur
    for (i in 0..<n - x) {
        if (cur > max) {
            max = cur
            count = 1
        } else if (cur == max && max != 0) {
            count++
        }
        cur -= arr[i]
        cur += arr[i + x]
    }
    if (cur > max) {
        max = cur
        count = 1
    } else if (cur == max && max != 0) {
        count++
    }
    if (count == 0) {
        bw.write("SAD\n")
    } else{
        bw.write(max.toString() + "\n")
        bw.write(count.toString() + "\n")
    }
    bw.flush()
    bw.close()
}
