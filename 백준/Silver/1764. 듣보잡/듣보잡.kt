import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val notListenSee = mutableMapOf<String,Int>()
    val repeat = br.readLine()
    val repeatNum = StringTokenizer(repeat)
    repeat(repeatNum.nextToken().toInt()) {
        notListenSee.put(br.readLine(),1)
    }
    repeat(repeatNum.nextToken().toInt()) {
        val input = br.readLine()
        if (notListenSee.containsKey(input)){
            notListenSee.put(input, 2)
        }
    }
    var count = 0
    for (i in notListenSee.toSortedMap()){
        if (i.value == 2)
            count++
    }
    bw.write("$count\n")
    for (i in notListenSee.toSortedMap()){
        if (i.value == 2)
            bw.write(i.key+"\n")
    }
    bw.flush()
    bw.close()
}

