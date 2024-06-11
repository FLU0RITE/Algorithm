class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
    
        for(index in 0.. t.length - p.length){
            var eachLine = ""
            for(index2 in index..index + p.length - 1){
                eachLine += t[index2]
            }
            if(eachLine.toDouble() <= p.toDouble()){
                answer++
            }
            
        }
        
        return answer
    }
}