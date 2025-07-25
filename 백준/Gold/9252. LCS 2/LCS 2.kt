import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st1 = br.readLine()
    val st2 = br.readLine()
    val n = st1.length
    val m = st2.length
    val dp = Array(n+1) { Array(m+1) { 0 } }
    for (i in 1 .. n) {
        for (j in 1..m) {
            if(st1[i-1] == st2[j-1]) {
                dp[i][j] = dp[i-1][j-1] +1
            } else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
            }
        }
    }
    val answer = mutableListOf<Char>()
    var i = n
    var j = m
    while (i != 0 && j != 0) {
        if (st1[i-1] == st2[j-1]) {
            answer.add(st1[i-1])
            i -= 1
            j -= 1
        } else {
            if (dp[i-1][j] > dp[i][j-1]){
                i-=1
            } else {
                j -= 1
            }
        }
    }
    bw.write(answer.size.toString())
    bw.write(answer.reversed().joinToString("")+"\n")
    
    bw.flush()
}

