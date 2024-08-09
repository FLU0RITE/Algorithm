import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	var i = 0
	var I = 0
	var l = 0
	var L = 0
	for (each in sc.nextLine()){
		if (each == '1'){
			i++
		}else if(each == 'I'){
			I++
		}else if(each == 'l'){
			l++
		}else if(each == '|'){
			L++
		}
	}
	println(i)
	println(I)
	println(l)
	println(L)
}