import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val repeatNum = br.readLine().toInt()
    var nums = mutableListOf<Int>()
    repeat(repeatNum){
        val num =br.readLine().toInt()
        nums.add(0)
        nums.add(1)
        nums.add(2)
        nums.add(4)
        nums.add(7)

        for (i in 5..num){
            nums.add(nums[i-1]+nums[i-2]+nums[i-3])
        }
        bw.write("${nums[num]}\n")
        nums = mutableListOf()
    }

    bw.flush()
    bw.close()
}

