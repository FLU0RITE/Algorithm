import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = mutableListOf<Int>()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    backTracking(a, b, arr, 1, bw)
    bw.flush()
}

fun backTracking(a: Int, b: Int, arr: MutableList<Int>, cur: Int, bufferedWriter: BufferedWriter) {
    if (arr.size >= b) {
        bufferedWriter.write(arr.joinToString(" ") + "\n")
        return
    }
    for (i in cur..a) {
        arr.add(i)
        backTracking(a, b, arr.toMutableList(), i, bufferedWriter)
        arr.removeLast()
    }
}