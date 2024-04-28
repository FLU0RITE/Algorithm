import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var white = 0
var blue = 0
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val totalRepeatNum = br.readLine().toInt()
    val paper = Array(totalRepeatNum){Array(totalRepeatNum){0} }
    for(y in 0..<totalRepeatNum) {
        val eachLine = StringTokenizer(br.readLine())
        val eachLinePaper = mutableListOf<Int>()
        for(x in 0..<totalRepeatNum){
            paper[y][x] = eachLine.nextToken().toInt()
        }
    }
    divideAndConquer(paper)
    bw.write("$white\n")
    bw.write("$blue\n")
    bw.flush()
    bw.close()
}

fun divideAndConquer(paper:Array<Array<Int>>){
    val standard = paper[0][0]
    var isDivide = false
    for (line in paper){
        for (each in line){
            if (standard != each){
                isDivide = true
            }
        }
    }
    if (isDivide){
        val paperSize = paper[0].size
        val firstPaper = Array(paperSize/2){Array(paperSize/2){0} }
        val secondPaper = Array(paperSize/2){Array(paperSize/2){0} }
        val thirdPaper = Array(paperSize/2){Array(paperSize/2){0} }
        val fourthPaper = Array(paperSize/2){Array(paperSize/2){0} }
        for (y in 0..<paperSize/2){
            for (x in 0..<paperSize/2){
                firstPaper[y][x] = paper[y][x]
            }
        }
        for (y in 0..<paperSize/2){
            for (x in 0..<paperSize/2){
                secondPaper[y][x] = paper[y][x+paperSize/2]
            }
        }
        for (y in 0..<paperSize/2){
            for (x in 0..<paperSize/2){
                thirdPaper[y][x] = paper[y+paperSize/2][x]
            }
        }
        for (y in 0..<paperSize/2){
            for (x in 0..<paperSize/2){
                fourthPaper[y][x] = paper[y+paperSize/2][x+paperSize/2]
            }
        }

        divideAndConquer(firstPaper)
        divideAndConquer(secondPaper)
        divideAndConquer(thirdPaper)
        divideAndConquer(fourthPaper)
    }else{
        if (standard == 0){
            white += 1
        }else{
            blue += 1
        }
    }

}



