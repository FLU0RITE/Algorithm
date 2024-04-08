import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val totalRepeatNum = br.readLine().toInt()
    repeat(totalRepeatNum) {
        val volume = StringTokenizer(br.readLine())
        val totalRow = volume.nextToken().toInt()
        val totalColumn = volume.nextToken().toInt()
        val napaCabbage = volume.nextToken().toInt()
        val square = Array(totalColumn) { Array(totalRow) { 0 } }
        var square2 = Array(totalColumn) { Array(totalRow) { 0 } }
        repeat(napaCabbage) {
            val eachLine = StringTokenizer(br.readLine())
            val row = eachLine.nextToken().toInt()
            val column = eachLine.nextToken().toInt()
            square[column][row] = 1
        }
        var count = 0
        for (columnIndex in 0..<totalColumn) {
            for (rowIndex in 0..<totalRow) {
                if (square[columnIndex][rowIndex] == 1 && square2[columnIndex][rowIndex] == 0) {
                    count += 1
                    square2 = bfs(square, square2, rowIndex, columnIndex, totalRow, totalColumn, count)
                }
            }
        }
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()
}

fun bfs(
    square: Array<Array<Int>>,
    square2: Array<Array<Int>>,
    row: Int,
    column: Int,
    totalRow: Int,
    totalColumn: Int,
    count: Int
): Array<Array<Int>> {
    var square3 = square2
    if (totalColumn-1 > column) {
        if (square[column + 1][row] == 1 && square2[column + 1][row] == 0) {
            square2[column + 1][row] = count
            square3 = bfs(square, square2, row, column + 1, totalRow, totalColumn, count)
        }
    }
    if (0 < column) {
        if (square[column - 1][row] == 1 && square2[column - 1][row] == 0) {
            square2[column - 1][row] = count
            square3 = bfs(square, square2, row, column - 1, totalRow, totalColumn, count)
        }
    }
    if (totalRow-1 > row) {
        if (square[column][row + 1] == 1 && square2[column][row + 1] == 0) {
            square2[column][row + 1] = count
            square3 = bfs(square, square2, row+1, column, totalRow, totalColumn, count)
        }
    }
    if (0 < row) {
        if (square[column][row - 1] == 1 && square2[column][row - 1] == 0) {
            square2[column][row - 1] = count
            square3 = bfs(square, square2, row-1, column, totalRow, totalColumn, count)
        }
    }
    return square3
}