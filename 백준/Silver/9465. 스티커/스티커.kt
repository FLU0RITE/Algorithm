import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val board = Array(2) { IntArray(n) }
        for (i in 0..<2) {
            board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        dpSolve(n, board)
    }

}
fun dpSolve(n: Int, board: Array<IntArray>) {
    if (n == 1) {
        println(maxOf(board[0][0], board[1][0]))
        return
    }

    val dp = Array(2) { IntArray(n) }

    dp[0][0] = board[0][0]
    dp[1][0] = board[1][0]
    dp[0][1] = dp[1][0] + board[0][1]
    dp[1][1] = dp[0][0] + board[1][1]

    for (i in 2..<n) {
        for (j in 0..1) {
            dp[j][i] = maxOf(dp[0][i - 2], dp[1][i - 2]) + board[j][i]
            dp[j][i] = maxOf(dp[j][i], dp[(j + 1) % 2][i - 1] + board[j][i])
        }
    }

    println(maxOf(dp[0][n - 1], dp[1][n - 1]))
}
