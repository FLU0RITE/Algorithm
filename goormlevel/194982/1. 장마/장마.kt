import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val m = sc.nextInt()
	val height = mutableListOf<Int>()
	var check = Array(n){false}
	repeat(n){
		height.add(sc.nextInt())
	}
	for(index in 1..m){
		val s = sc.nextInt() -1
		val e = sc.nextInt() -1
		for (i in s..e){
			height[i]++
			check[i] = true
		}
		if (index % 3 == 0){
			for (i in 0 until n){
				if (check[i]){
					height[i]--
				}
			}
			check = Array(n){false}
		}
	}
	println(height.joinToString(" "))
}