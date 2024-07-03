import java.util.Scanner
fun main(args: Array<String>) {
    val input = readLine()
    val line = readLine()
    var answer = StringBuilder()
    var alphabet = ','
    var num = 0
    for (i in 0..line!!.length-1){
			val each = line[i]
        if (each >= 'a' && each <= 'z'){
            alphabet = each
        } else {
            num = each.toString().toInt()
						val square = num * num % 26
            if (alphabet + square > 'z'){
                answer.append(alphabet + square - 26)
            } else {
                answer.append(alphabet + square)
            }

        }
    }
    println(answer)
}