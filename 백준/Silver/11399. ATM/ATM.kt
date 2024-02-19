import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()
    val times = StringTokenizer(br.readLine())
    var eachTime = mutableListOf<Int>()
    repeat(count) {
        eachTime.add(times.nextToken().toInt())
    }
    eachTime = eachTime.sorted().toMutableList()

    var total = 0
    for (i in 0..count) {
        for (j in 0..<i) {
            total += eachTime[j]
        }
    }
    bw.write("$total\n")
    bw.flush()
    bw.close()
}

