import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val firstLine = br.readLine().toInt()
    val square = mutableListOf<Int>()
    square.add(0)
    square.add(1)
    square.add(2)
    square.add(3)
    square.add(5)
    for (i in 5..firstLine){
        square.add((square[i-1]+square[i-2])%10007)
    }


    bw.write("${square[firstLine]%10007}")

    bw.flush()
    bw.close()
}

