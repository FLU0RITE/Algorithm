import java.util.Scanner
fun main(args: Array<String>) {
	val input = readLine()!!.toInt()
	for (i in 1..input){
		for(j in 1..input-i){
			print(" ")
		}
		for(j in 1..i){
			print("*")
		}
		println()
	}
}