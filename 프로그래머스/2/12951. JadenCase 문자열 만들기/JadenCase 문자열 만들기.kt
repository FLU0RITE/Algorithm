class Solution {
    fun solution(s: String): String {
        val result = StringBuilder()
        var isStartOfWord = true

        for (char in s) {
            if (char == ' ') {
                result.append(char)
                isStartOfWord = true
            } else {
                if (isStartOfWord) {
                    result.append(char.toUpperCase())
                } else {
                    result.append(char.toLowerCase())
                }
                isStartOfWord = false
            }
        }
        return result.toString()
    }
}
