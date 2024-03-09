import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var zero = 0
var one = 0
var dp = mutableListOf<Int>()
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()

    repeat(count) {
        val num = br.readLine().toInt()
        bw.write("${fibonacciZero(num)} ${fibonacciOne(num)}\n")

    }

    bw.flush()
    bw.close()
}

fun fibonacciZero(n: Int): Int {
    dp = mutableListOf()
    dp.add(1)
    dp.add(0)
    dp.add(1)
    if (n > 2) {
        for (i in 3..n) {
            dp.add(dp[i-1] + dp[i - 2])
        }
    }
    return dp[n]
}

fun fibonacciOne(n: Int): Int {
    dp = mutableListOf()
    dp.add(0)
    dp.add(1)
    dp.add(1)
    if (n > 2) {
        for (i in 3..n) {
            dp.add(dp[i-1] + dp[i - 2])
        }
    }


    return dp[n]
}
