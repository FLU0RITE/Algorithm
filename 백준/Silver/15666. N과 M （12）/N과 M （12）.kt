import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = mutableListOf<Int>()
    val arr2 = mutableListOf<Int>()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val numbers2 = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList()
    val numbers = numbers2.toSortedSet().toMutableList()
    backTracking(a, b, arr, arr2, bw, numbers)
    bw.flush()
}

fun backTracking(
    a: Int,
    b: Int,
    arr: MutableList<Int>,
    arr2: MutableList<Int>,
    bufferedWriter: BufferedWriter,
    numbers: List<Int>,
) {
    if (arr.size == b) {
        bufferedWriter.write(arr.joinToString(" ") + "\n")
        return
    }
    for (i in 0 until numbers.size) {
        if (arr2.filter { it > i }.size != 0) {
            continue
        }
        arr2.add(i)
        arr.add(numbers[i])
        backTracking(a, b, arr, arr2, bufferedWriter, numbers)
        arr.removeLast()
        arr2.remove(i)
    }
}