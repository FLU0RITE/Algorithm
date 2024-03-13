import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var num = br.readLine().toInt()
    bw.write("${makeOne(num)}")
    bw.flush()
    bw.close()
}

fun makeOne(inputNum: Int): Int {
    val num = inputNum
    var numbers = mutableListOf<Int>()
    numbers.add(-1)
    numbers.add(0)
    numbers.add(1)
    numbers.add(1)
    for (index in 4..inputNum) {
        if (index % 3 == 0 && index % 2 == 0) {
            if (numbers[index / 3] < numbers[index / 2]) {
                if (numbers[index / 3] < numbers[index - 1]) {
                    numbers.add(numbers[index / 3] + 1)
                } else {
                    numbers.add(numbers[index - 1] + 1)
                }
            } else {
                if (numbers[index / 2] < numbers[index - 1]) {
                    numbers.add(numbers[index / 2] + 1)
                } else {
                    numbers.add(numbers[index - 1] + 1)
                }
            }
        } else if (index % 3 == 0) {
            if (numbers[index / 3] < numbers[index - 1]) {
                numbers.add(numbers[index / 3] + 1)
            } else {
                numbers.add(numbers[index - 1] + 1)
            }
        } else if (index % 2 == 0) {
            if (numbers[index / 2] < numbers[index - 1]) {
                numbers.add(numbers[index / 2] + 1)
            } else {
                numbers.add(numbers[index - 1] + 1)
            }
        } else {
            numbers.add(numbers[index - 1] + 1)
        }

    }
    return numbers[inputNum]
}
