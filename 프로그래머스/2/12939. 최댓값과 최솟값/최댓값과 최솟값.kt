class Solution {
    fun solution(s: String): String {
        var answer = ""
        var str = s.split(" ")
        var index = 0
        
        var min =0
        var max=0
        
        for (each in str){
            val e = each.toInt()
            if (index == 0){
                min = e
                max = e
            }
            if (min > e){
                min = e
            }
            if(max < e){
                max = e
            }
            index++
        }
        answer = min.toString() + " " + max.toString()
        return answer
    }
}