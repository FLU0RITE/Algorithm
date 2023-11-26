import java.util.*
import kotlin.math.cbrt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input: String = readLine()
    val line = input.toList()
    var count = mutableListOf<Int>()
    val alphabet = mutableListOf<Char>()
    for (each in 0..25){
        alphabet.add('a'+each)
    }
    for (each in alphabet){
        var check = true
        for ((index,each2) in line.withIndex()){
            if (each == each2){
                count.add(index)
                check = false
                break
            }
        }
        if (check){
            count.add(-1)
        }
    }
    for (each in count)
        print("$each ")
}








