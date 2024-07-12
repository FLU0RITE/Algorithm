import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val f = sc.nextInt()
    var s = sc.nextInt()
    var more = 0
    if (f > s)
        more = f
    else more = s
    var max = 0
    for (i in 1..more){
        if (f%i==0&&s%i==0){
            max = i
        }
    }
    println(max)
    var min = 0
    for (i in 1..f*s){
        if (i%f==0&&i%s==0){
            min = i
            break
        }
    }
    println(min)
}

