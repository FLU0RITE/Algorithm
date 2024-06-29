import java.util.Scanner
fun main(args: Array<String>) {
	val input = readLine()!!.toInt()
	for (i in input downTo 1){
		for (j in 1..i){
			print("*")
		}
		println()
	}
	
}