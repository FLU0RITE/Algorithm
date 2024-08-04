import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val level = List(5){mutableListOf<Int>()}
	var limit = Array(5){0}
	var total = 0
	for (i in 0..4){
		limit[i] = sc.nextInt()
	}
	repeat(n){
		level[sc.nextInt()-1].add(sc.nextInt())
	}
	for ((i,problems) in level.withIndex()){
		if (problems.isNotEmpty())
			total+=60
		problems.sort()
		var prev = 0
		for (j in 0 until limit[i]){
			if (prev != 0){
				total += problems[j] - prev
			}
			total += problems[j]
			prev = problems[j]
		}
		prev = 0
	}
	
	println(total-60)
}