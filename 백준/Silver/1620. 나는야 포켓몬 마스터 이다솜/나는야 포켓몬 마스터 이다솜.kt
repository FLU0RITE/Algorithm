import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val poketmonNum = sc.nextInt()
    val questionNum = sc.nextInt()
    val dogam = HashMap<String,Int>()
    val dogam2 = HashMap<Int,String>()
    sc.nextLine()
    for (i in 1..poketmonNum){
        val n = sc.nextLine()
        dogam.put(key = n, value = i)
        dogam2.put(key = i, value = n)
    }
    repeat(questionNum){
        val line = sc.nextLine()
        if (line[0]>='0' && line[0]<='9'){
            println( dogam2.getValue(line.toInt()))
        }else{
            println( dogam.getValue(line))
        }
    }
}

