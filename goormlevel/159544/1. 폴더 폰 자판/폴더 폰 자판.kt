import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val len = sc.nextInt()
    val secondLine = sc.next()
    
    val panel = arrayOf(
        arrayOf("1", ".", ",", "?", "!"),
        arrayOf("2", "A", "B", "C"),
        arrayOf("3", "D", "E", "F"),
        arrayOf("4", "G", "H", "I"),
        arrayOf("5", "J", "K", "L"),
        arrayOf("6", "M", "N", "O"),
        arrayOf("7", "P", "Q", "R", "S"),
        arrayOf("8", "T", "U", "V"),
        arrayOf("9", "W", "X", "Y", "Z")
    )

    val result = StringBuilder()
    var memory = mutableListOf<Int>()
    
    for (i in 0 until len) {
        val each = secondLine[i].toString().toInt()
        if (memory.isEmpty() || each == memory[0]) {
            memory.add(each)
        } else {
            result.append(panel[memory[0] - 1][(memory.size - 1) % panel[memory[0] - 1].size])
            memory.clear()
            memory.add(each)
        }
    }

    // 마지막 메모리에 남아 있는 문자 추가
    if (memory.isNotEmpty()) {
        result.append(panel[memory[0] - 1][(memory.size - 1) % panel[memory[0] - 1].size])
    }

    println(result.toString())
}
