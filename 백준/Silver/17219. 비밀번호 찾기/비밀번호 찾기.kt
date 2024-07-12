import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val total = sc.nextInt()
    var searchNum = sc.nextInt()
    var pw = HashMap<String,String>()
    sc.nextLine()
    repeat(total){
        pw.put(sc.next(),sc.next())
        sc.nextLine()
    }
    repeat(searchNum){
        val each = sc.nextLine()
        println(pw.get(each))
    }
}

