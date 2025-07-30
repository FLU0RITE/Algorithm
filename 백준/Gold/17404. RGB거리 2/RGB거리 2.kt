import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val nums = Array(n, { br.readLine().split(" ").map { it.toInt() } })
    val answers = mutableListOf<Int>()

        for (k in 0..2){
            val dp = Array(n ) { arrayOf(0,0,0) }
            if (k==0) dp[0][0] = nums[0][0] else dp[0][0] = 1001
            if (k==1) dp[0][1] = nums[0][1] else dp[0][1] = 1001
            if (k==2) dp[0][2] = nums[0][2] else dp[0][2] = 1001
            for (i in 1 until n) {
                dp[i][0] = minOf(dp[i - 1][1], dp[i - 1][2])+nums[i][0]
                dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][2])+nums[i][1]
                dp[i][2] = minOf(dp[i - 1][0], dp[i - 1][1])+nums[i][2]
            }
            for (j in 0 .. 2) {
                if(j!=k) answers.add(dp[n-1][j])
            }
        }




    bw.write(answers.min().toString())
    bw.flush()
}

