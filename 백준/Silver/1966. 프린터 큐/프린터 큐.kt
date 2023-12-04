import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    repeat(repeatNum) {
        val nums = mutableListOf<Int>()
        val check = mutableListOf<Boolean>()
        val firstLine = StringTokenizer(readLine())
        val count = firstLine.nextToken().toInt()
        val sequence = firstLine.nextToken().toInt()
        val secondLine = StringTokenizer(readLine())
        while (secondLine.hasMoreTokens()) {
            nums.add(secondLine.nextToken().toInt())
            check.add(false)
        }
        var index = 0
        var answer = 0
        while (true) {
            var max = 0
            for ((i,each) in nums.withIndex()){
                if (each > max && !check[i]){
                    max = each
                }
            }

            if (max == nums[index]) {
                check[index] = true
                answer++
                if (check[sequence])
                    break
            }
            index++
            if (nums.size == index)
                index = 0

        }
        println(answer)
    }
}

