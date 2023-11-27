import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val inputNum = StringTokenizer(readLine())
    val answer = mutableListOf<Int>()

    while (inputNum.hasMoreTokens()){
        answer.add(inputNum.nextToken().toInt())
    }
    var count = 0
    for (i in 1..8){
        if (answer[i-1] == i){
            count++
        }
    }
    if (count==8){
        println("ascending")
        return@with
    }
    count = 0
    for (i in 1..8){
        if (answer[i-1] == 9-i){
            count++
        }
    }
    if (count==8){
        println("descending")
        return@with
    }
    println("mixed")
}








