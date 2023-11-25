import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input: String = readLine().uppercase(Locale.getDefault())
    val line = input.toList()
    var count = 0
    var max = 0
    val alphabet = line.toSet()
    var answer:Char = ' '
    for (each in alphabet){
        count = 0
        for (each2 in line) {
            if (each == each2){
                count++
            }
        }
        if (max < count){
            max = count
            answer = each
        }
        if (max == count && each != answer)
            answer = '?'
    }
    println(answer)
}








