class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var list = intArrayOf()
        var string = n.toString()
        for (i in string){
            list += i.toInt() - 48
        }
        list.sortDescending()
        for (i in list){
            answer += i
            answer *= 10
        }
        return answer/10
    }
}