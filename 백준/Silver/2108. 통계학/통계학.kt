import java.util.StringTokenizer
import kotlin.math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()
    val nums = mutableListOf<Int>()
    repeat(repeatNum) {
        nums.add(readLine().toInt())
    }
    if (nums.sum() < 0){
        if (nums.sum() % repeatNum < -repeatNum / 2)
            println(nums.sum() / repeatNum - 1)
        else
            println(nums.sum() / repeatNum)
    } else{
        if (nums.sum() % repeatNum > repeatNum / 2)
            println(nums.sum() / repeatNum + 1)
        else
            println(nums.sum() / repeatNum)
    }


    val numsSorted = nums.sorted()
    println(numsSorted[repeatNum/2])

    val numCount = mutableMapOf<Int,Int>()
    for (i in nums){
        if (numCount.isEmpty()){
            numCount.put(i,1)
            continue
        }
        if (numCount.contains(i))
            numCount[i] = numCount[i]!! + 1
        else {
            numCount.put(i,1)
        }
    }
    var max = 0
    for (k in numCount){
        if (k.value > max){
            max = k.value
        }
    }
    var answerKeys = mutableListOf<Int>()
    for (k in numCount){
        if (k.value == max)
            answerKeys.add(k.key)
    }
    answerKeys = answerKeys.sorted().toMutableList()
    if (answerKeys.size > 1)
        println(answerKeys[1])
    else println(answerKeys[0])
    println(numsSorted[repeatNum-1]-numsSorted[0])
}

