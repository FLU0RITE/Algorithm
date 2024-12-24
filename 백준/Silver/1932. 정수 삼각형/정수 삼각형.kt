import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val board = Array(n) { IntArray(n) }
    for (i in 0..<n) {
        board[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    dpSolve(n, board)
}

fun dpSolve(n: Int, board: Array<IntArray>) {
    if (n == 1) {
        println(board[0][0])
        return
    }

    val dp = Array(n) { IntArray(n) }

    dp[0][0] = board[0][0]
    dp[1][0] = board[1][0] + board[0][0]
    dp[1][1] = board[1][1] + board[0][0]

    for (j in 2..<n) {
        for (i in 0..j) {
            if (i == 0) {
                dp[j][i] = dp[j - 1][i] + board[j][i]
            } else if (i == j) {
                dp[j][i] = dp[j - 1][i - 1] + board[j][i]
            } else {
                dp[j][i] = maxOf(dp[j - 1][i], dp[j - 1][i - 1]) + board[j][i]
            }
        }
    }
    println(dp[n-1].maxOf { it })
}
