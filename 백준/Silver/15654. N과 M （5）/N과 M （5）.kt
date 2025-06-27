import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = mutableListOf<Int>()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    backTracking(a, b, arr, 0, bw, numbers)
    bw.flush()
}

fun backTracking(a: Int, b: Int, arr: MutableList<Int>, cur: Int, bufferedWriter: BufferedWriter, numbers: List<Int>) {
    if (arr.size >= b) {
        bufferedWriter.write(arr.joinToString(" ") + "\n")
        return
    }
    for (i in cur until numbers.size) {
        if (arr.contains(numbers[i])) {
            continue
        }
        arr.add(numbers[i])
        backTracking(a, b, arr.toMutableList(), 0, bufferedWriter, numbers)
        arr.removeLast()
    }
}