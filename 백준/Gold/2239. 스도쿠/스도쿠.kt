import java.io.*
import java.util.*
var found = false
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sudoku = mutableListOf<MutableList<Int>>()
    repeat(9){
        sudoku.add(br.readLine().split("").filter { it != "" }.map { it.toInt() }.toMutableList())
    }

    backTracking(0,0,sudoku)
    for (i in 0..8){
        bw.write(sudoku[i].joinToString("") + "\n")
    }
    bw.flush()
}
fun backTracking(i:Int,j:Int,sudoku:MutableList<MutableList<Int>>): Boolean{
    if (found) return true // 이미 해답 찾음

    if (i == 9) {
        found = true
        return true
    }
    val numbers = mutableListOf<Int>()
    if(sudoku[i][j] == 0){
        for (index in 0..8){
            numbers.add(sudoku[index][j])
            numbers.add(sudoku[i][index])
        }
        val x = i/3
        val y = j/3
        for (indexX in x*3 until (x+1)*3){
            for (indexY in y*3 until (y+1)*3){
                numbers.add(sudoku[indexX][indexY])
            }
        }
        val numbersSet = numbers.toSet()
        val selection = listOf(1,2,3,4,5,6,7,8,9) - numbersSet

        for (branch in selection) {
            sudoku[i][j] = branch
            val result = if (j == 8) {
                backTracking(i + 1, 0, sudoku)
            } else {
                backTracking(i, j + 1, sudoku)
            }
            if (result) return true
            sudoku[i][j] = 0
        }


    } else {
        val result = if (j == 8) {
            backTracking(i + 1, 0, sudoku)
        } else {
            backTracking(i, j + 1, sudoku)
        }
        if (result) return true

    }
    return false
}