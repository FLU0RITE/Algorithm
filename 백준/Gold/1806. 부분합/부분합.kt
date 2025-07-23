import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = 0
    var sum = 0
    var min = 100000
    while (start < n) {
        if (sum < s) {
            if (end == n) break
            sum += arr[end]
            end += 1
        } else {
            min = minOf(min, end - start)
            sum -= arr[start]
            start += 1
        }
    }
    if (min == 100000) bw.write("0")
    else bw.write(min.toString())

    bw.flush()
}
