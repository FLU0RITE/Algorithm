class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        
        for (eachPhoto in photo){
            var eachTotal = 0
            for(person in eachPhoto){
                for(index in 0..name.size-1){
                    if (name[index] == person){
                        eachTotal += yearning[index]
                    }
                }
            }
            
            answer += eachTotal
            eachTotal = 0
        }
        
        
        
        return answer
    }
}