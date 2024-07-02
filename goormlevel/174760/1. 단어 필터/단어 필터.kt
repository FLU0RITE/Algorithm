import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val firstLength = sc.nextInt()
    val secondLength = sc.nextInt()
    sc.nextLine()
    val firstLine = sc.nextLine()
    var secondLine = sc.nextLine()

    var i = 0
    var leng = secondLine.length

    while (i <= leng - firstLength) {
        if (firstLine.compareTo(secondLine.substring(i, i + firstLength)) == 0) {
            secondLine = secondLine.substring(0, i) + secondLine.substring(i + firstLength, leng)
            leng -= firstLength
            i = if (i - firstLength < 0) 0 else i - firstLength
        } else {
            i++
        }
    }

    if (secondLine.isEmpty())
        println("EMPTY")
    else
        println(secondLine)
}
