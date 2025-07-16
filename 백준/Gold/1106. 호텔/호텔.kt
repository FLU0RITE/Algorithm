import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (c, n) = br.readLine().split(" ").map { it.toInt() }
    val ads = mutableListOf<Pair<Int, Int>>()  // (cost, customer)

    repeat(n) {
        val (money, count) = br.readLine().split(" ").map { it.toInt() }
        ads.add(money to count)
    }

    val dp = IntArray(c + 101) { Int.MAX_VALUE }
    dp[0] = 0  // base case

    for (i in 1..c + 100) {
        for ((cost, customer) in ads) {
            if (i - customer >= 0 && dp[i - customer] != Int.MAX_VALUE) {
                dp[i] = min(dp[i], dp[i - customer] + cost)
            }
        }
    }

    // c 이상에서 최소 비용 찾기
    var answer = Int.MAX_VALUE
    for (i in c..c + 100) {
        answer = min(answer, dp[i])
    }

    bw.write("$answer\n")
    bw.flush()
}
