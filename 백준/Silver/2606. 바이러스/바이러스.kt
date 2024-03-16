import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
var answer = mutableListOf<Int>()
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var num = br.readLine().toInt()
    var computers = mutableListOf<MutableList<Int>>()
    for(i in 0..num){
        computers.add(mutableListOf())
    }
    var repeatNum = br.readLine().toInt()
    repeat(repeatNum){
        var nums = StringTokenizer(br.readLine())
        val first =nums.nextToken().toInt()
        val second = nums.nextToken().toInt()
        computers[first].add(second)
        computers[second].add(first)
    }
    bfs(computers,answer,1)
    if (answer.size == 0)
        bw.write("${answer.size}")
    else
        bw.write("${answer.size-1}")
    bw.flush()
    bw.close()
}
fun bfs(computers:List<List<Int>>,answer:MutableList<Int>,index:Int){
    if (computers[index].isEmpty())
        return
    for (i in 0..<computers[index].size){
        if (answer.contains(computers[index][i])){
        } else{
            answer.add(computers[index][i])
            bfs(computers,answer,computers[index][i])
        }
    }
    return
}

