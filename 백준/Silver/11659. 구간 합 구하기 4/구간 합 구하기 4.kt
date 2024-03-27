import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val firstLine = StringTokenizer(br.readLine())
    val numCount = firstLine.nextToken().toInt()
    val repeatNum = firstLine.nextToken().toInt()
    val nums = mutableListOf<Int>()
    val accumulatedNums = mutableListOf<Int>()
    val secondLine = StringTokenizer(br.readLine())
    var accumulator = 0
    repeat(numCount){
        val each = secondLine.nextToken().toInt()
        nums.add(each)
        accumulator += each
        accumulatedNums.add(accumulator)
    }
    repeat(repeatNum){
        val eachLine = StringTokenizer(br.readLine())
        val first = eachLine.nextToken().toInt()
        val second = eachLine.nextToken().toInt()
        bw.write("${accumulatedNums[second-1] - accumulatedNums[first-1]+ nums[first-1]}\n")
    }

    bw.flush()
    bw.close()
}

