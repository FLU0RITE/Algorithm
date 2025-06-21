import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = List(n) { br.readLine().split(" ").map { it.toInt() } }

    val maxDp = Array(n) { IntArray(3) }
    val minDp = Array(n) { IntArray(3) }

    for (j in 0..2) {
        maxDp[0][j] = arr[0][j]
        minDp[0][j] = arr[0][j]
    }

    for (i in 1 until n) {
        for (j in 0..2) {
            val fromIndices = listOf(j - 1, j, j + 1).filter { it in 0..2 }
            maxDp[i][j] = arr[i][j] + fromIndices.maxOf { maxDp[i - 1][it] }
            minDp[i][j] = arr[i][j] + fromIndices.minOf { minDp[i - 1][it] }
        }
    }

    val maxResult = maxDp[n - 1].max()
    val minResult = minDp[n - 1].min()

    bw.write("$maxResult $minResult\n")
    bw.flush()
}
