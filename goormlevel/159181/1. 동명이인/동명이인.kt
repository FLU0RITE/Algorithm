import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val num = sc.nextInt()
	val criterion = sc.next()
	sc.nextLine()
	val names = mutableListOf<String>()
	repeat(num){
		names.add(sc.nextLine())
	}
	var count = 0
	for(each in names){
		for (i in 0..each.length-criterion.length){
			if (criterion.compareTo(each.substring(i,i+criterion.length))==0){
				count++
				break
			}
		}
		
	}
	
	print(count)
}