class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = intArrayOf(-1, -1)
        var total = 0
        var minLength = Int.MAX_VALUE
        var start = 0
        var end = 0

        while (end <= sequence.size) {
            if (total < k) {
                if (end < sequence.size) {
                    total += sequence[end]
                }
                end++
            } else {
                if (total == k) {
                    if (end - start < minLength) {
                        minLength = end - start
                        answer = intArrayOf(start, end - 1)
                    }
                }
                total -= sequence[start]
                start++
            }
        }
        return answer
    }
}
