import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val tabStop = scanner.nextInt()
    scanner.nextLine()

    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        println(convertTabsToSpaces(line, tabStop).trimEnd())
    }
}

fun convertTabsToSpaces(line: String, tabStop: Int): String {
    val sb = StringBuilder()
    var column = 0
    var isMedium = false
    for (char in line) {
        if (char == '\t') {
            if (isMedium){
                sb.append('\t')
                continue
            }
            val spacesToAdd = tabStop - (column % tabStop)
            repeat(spacesToAdd) {
                sb.append(' ')
            }
            column = 0
        } else if (char == ' '){
            sb.append(char)
            column++
        } else {
            sb.append(char)
            isMedium = true
        }
    }

    return sb.toString()
}
