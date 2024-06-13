class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var check = Array(n+1){0}
        for (index in section){
            check[index] = 1
        }
        for (index in section){
            if(check[index] == 1){
                answer++
                if (index + m  > n){
                    for (index2 in index..n){
                        check[index2] = 0
                    }
                }
                else{
                    for (index2 in index..index+m-1){
                        check[index2] = 0
                    }
                }
                
            }
            
            
        }
        
        
        return answer
    }
}