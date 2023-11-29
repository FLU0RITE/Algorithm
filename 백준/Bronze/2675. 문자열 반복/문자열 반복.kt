import java.util.StringTokenizer


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeatNum = readLine().toInt()

    repeat(repeatNum) {
        val line = StringTokenizer(readLine())
        val eachRepeatNum = line.nextToken().toInt()
        for (each in line.nextToken()){
            repeat(eachRepeatNum){
                print(each)
            }
        }
        println()
    }


}








