import java.util.Scanner
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val len = sc.nextInt()
    sc.nextLine()
    val str = sc.nextLine()
    val nums = arrayOf("ze","qw","as","zx","we","sd","xc","er","df","cv")
    val ans = mutableListOf<Int>()
    for(i in 0 until str.length-1){
        val each = StringBuilder()
        each.append(str[i])
        each.append(str[i+1])
        for ((i,num) in nums.withIndex()){
            if (num == each.toString()){
                ans.add(i)
                break
            }
        }
    }

    print(ans.joinToString().replace(", ",""))
}