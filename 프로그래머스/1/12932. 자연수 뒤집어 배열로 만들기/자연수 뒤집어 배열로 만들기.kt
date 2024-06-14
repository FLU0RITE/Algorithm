class Solution {
    fun solution(n: Long): IntArray {
        var answer = intArrayOf()
        var string = n.toString()
        
        for(i in string.lastIndex downTo 0){
            answer += string[i].toInt() - 48
        }
        return answer
    }
}