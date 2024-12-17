fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = readLine()
    val arr = mutableListOf<Int>()
    val ans = mutableListOf<Int>()
    for (num in input.split(" ")){
        arr.add(num.toInt())
        ans.add(1)
    }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr.get(i) > arr.get(j)) {
                ans[i] = Math.max(ans.get(i), ans.get(j) + 1)
            }
        }
    }
    println(ans.max())
}