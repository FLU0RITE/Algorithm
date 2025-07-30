
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val m = br. readLine().toInt()
    val dp = Array(n+1){Array(n+1){0} }
    for (i in 1 .. n) {
        for (j in 1 .. n-i+1) {
            if (1 == i){
                dp[j][j] = 1
                continue
            }
            if (2 == i && nums[j-1] == nums[j]){
                dp[j][j+1] = 1
                continue
            }
            if (dp[j+1][j+i-2] == 1 && nums[j-1] == nums[j+i-2]) {
                dp[j][j+i-1] = 1
                continue
            }
        }
    }
    repeat(m) {
        val (s,e) = br.readLine().split(" ").map { it.toInt() }
        bw.write(dp[s][e].toString()+"\n")
    }
//    for (i in 0..n){
//        bw.write(dp[i].joinToString(" ")+"\n")
//    }

    bw.flush()
}

