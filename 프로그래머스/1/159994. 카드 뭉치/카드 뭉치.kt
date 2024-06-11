class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = "Yes"
        var index1 = 0
        var index2 = 0
        
        for (each in goal){
            if (index1 < cards1.size && each == cards1[index1]){
                index1++
            } 
            else if (index2 < cards2.size && each == cards2[index2]){
                index2++
            } else {
                answer = "No"
                break
            }
        }
        
        return answer
    }
}