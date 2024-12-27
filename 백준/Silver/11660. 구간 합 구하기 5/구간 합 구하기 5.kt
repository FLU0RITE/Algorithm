import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }


    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            dp[i][j] = board[i - 1][j - 1] +
                    dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
        }
    }


    val sb = StringBuilder()
    for (i in 0 until m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        val sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]
        sb.appendLine(sum)
    }
    print(sb)
}
