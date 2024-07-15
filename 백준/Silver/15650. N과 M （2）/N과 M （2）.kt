import java.util.LinkedList
import java.util.Queue
import java.util.Scanner
import java.util.Stack

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val nums = Stack<Int>()
    var i = 1
    var total = 0
    for (j in n-m+1..n){
        total+=j
    }
    while (true){
        nums.add(i)
        if (nums.size == m){
            println(nums.joinToString(" "))
            if (nums.sum()==total){
                break
            }
            if (nums.peek() != n){
                nums.pop()
            }else if (nums.peek() == n){
                var depth = 0
                while (nums.peek() == n-depth && !nums.isEmpty()){
                    nums.pop()
                    depth++
                    if (nums.peek() != n-depth){
                        i = nums.pop()
                        break
                    }
                }
            }
        }
        i++
    }

}

