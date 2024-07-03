import java.util.Scanner
fun main(args: Array<String>) {
	val input = readLine()
	val real = readLine()
	var answer = ""
	for (e in 0..real!!.length-1){
		if (real[e].isUpperCase()) answer += real[e].toLowerCase()
		else answer += real[e].toUpperCase()
	}
	println(answer)
}