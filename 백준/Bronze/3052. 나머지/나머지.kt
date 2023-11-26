

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    repeat(10) {
        val inputNum: Int = readLine().toInt()
        answer.add(inputNum%42)
    }
    println(answer.toSet().size)
}








