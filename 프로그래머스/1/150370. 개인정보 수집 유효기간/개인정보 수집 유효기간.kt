class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        fun dotSplit(s:String):List<Int>{
            return s.split(".").map{it.toInt()}
        }
        val termMap = mutableMapOf<String,Int>()
        for (t in terms) {
            val (ty,te) = t.split(" ")
            termMap[ty] = te.toInt()
        }
        val (tyy,tmm,tdd) = dotSplit(today)
        for ((i,p) in privacies.withIndex()) {
            val (date, type) = p.split(" ")
            var (yy,mm,dd) = dotSplit(date)
            if (tyy*28*12+tmm*28+tdd>=yy*28*12+(mm+termMap[type]!!)*28+dd) {
                answer += i+1
            }
        }
        return answer
    }
}