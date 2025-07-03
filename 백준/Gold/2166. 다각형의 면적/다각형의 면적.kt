import java.io.*
import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val arr = mutableListOf<List<BigDecimal>>()
    repeat(n) {
        arr.add(br.readLine().split(" ").map { it.toBigDecimal() })
    }

    var sum1 = BigDecimal.ZERO
    var sum2 = BigDecimal.ZERO

    arr.add(arr.first()) // 폐곡선

    for (i in 0 until arr.lastIndex) {
        sum1 += arr[i][0] * arr[i+1][1]
        sum2 += arr[i][1] * arr[i+1][0]
    }

    val area = (sum1 - sum2).abs().divide(BigDecimal("2"), 1, RoundingMode.HALF_UP)

    bw.write(area.toString())
    bw.flush()
}
