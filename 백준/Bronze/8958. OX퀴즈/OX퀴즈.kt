

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val inputNum: Int = readLine().toInt()
    val answer = mutableListOf<Int>()
    repeat(inputNum){
        val input: String = readLine()
        val line = input.toList()
        var eachCount = 0
        for ((index1,each) in line.withIndex()){
            var count = 0
            for (index in 0..index1){
                if (line[index] == 'O'){
                    count += 1
                } else{
                    count = 0
                }
            }
            eachCount+=count
        }
        answer.add(eachCount)
    }
    for (each in answer)
        println(each)
}








