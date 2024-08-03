import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val m = sc.nextInt()
	var ants = mutableListOf<Int>()
	var max = 0
	repeat(n){
		ants.add(sc.nextInt())
	}
	ants.sort()
	val temp = mutableListOf<Int>()
	for (index in 0 until ants.size){
		
		temp.add(ants[index])
		while(true){
			if (temp[temp.size-1]-temp[0]>m){
				temp.remove(temp[0])
			} else {break}
		}
		if (max < temp.size){
			max = temp.size
		}
	}
	println(n-max)
}
