import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val total = sc.nextInt()
	
	repeat(total){
		val x = sc.nextInt()
		val y = sc.nextInt()
		val limit = sc.nextInt()
		var min = 0
		if (x<0) min += -x
		else min += x
		if (y<0) min += -y
		else min += y
		if ((limit-min)%2==0 && min <= limit) println("YES")
		else println("NO")
	}
	
}