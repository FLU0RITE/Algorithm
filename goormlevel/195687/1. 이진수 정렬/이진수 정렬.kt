import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val k = scanner.nextInt()
    val nums = Array(count){Array(2){0} }
    scanner.nextLine()
    for (i in 0..count-1){
        nums[i][0] = scanner.nextInt()
    }

    nums.sortByDescending{it[0]}

    for ((i,each) in nums.withIndex()){
        var num = each[0]
        var countBinary = 0
        while (num!=1){
            if (num%2==1){
                countBinary++
            }
            num/=2
        }
        nums[i][1] = countBinary
    }
    nums.sortByDescending { it[1] }



    print(nums[k-1][0])
}