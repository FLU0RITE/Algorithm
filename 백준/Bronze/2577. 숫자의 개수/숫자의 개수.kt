import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var nums = 1
    repeat(3) {
        val line = readLine().toInt()
        nums *= line
    }
    val count = mutableListOf(0,0,0,0,0,0,0,0,0,0)
    while (nums != 0) {
        val num = nums % 10
        nums /= 10
        count[num]++
    }
    for (i in count)
        println(i)
}








