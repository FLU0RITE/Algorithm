import java.util.Scanner
fun main(args: Array<String>) {
	val input = readLine()!!.split(" ")
	val n = input[0].toInt()
	val k = input[1].toInt()
	val panel = Array(n){Array(n){0}}
	val count = Array(n){Array(n){0}}
	var answer = 0
	for (i in 0..n-1){
		val panelInput = readLine()!!.split(" ")
		for (j in 0..n-1){
			panel[i][j] = panelInput[j].toInt()
		}
	}
	
	for (i in 0..n-1){
		for (j in 0..n-1){
			if (panel[i][j]==0){
				if (i != n-1 && panel[i+1][j] == 1){
					count[i][j]++
				}
				if (i != 0 ){
					if (panel[i-1][j] == 1){count[i][j]++}
				}
				if (j != n-1){
					if(panel[i][j+1] == 1){
						count[i][j]++
					}
				}
				if (j != 0){
					if (panel[i][j-1] == 1){
						count[i][j]++
					}
				}
				if (i != 0 && j != 0){
					if(panel[i-1][j-1] == 1){
						count[i][j]++
					}
				}
				if (i != 0 && j != n-1){
					if (panel[i-1][j+1] == 1){
						count[i][j]++
					}
				}
				if (i != n-1 && j != 0){
					if(panel[i+1][j-1] == 1){
						count[i][j]++
					}
				}
				if (i != n-1 && j != n-1 && panel[i+1][j+1] == 1){
					count[i][j]++
				}
				if (count[i][j] == k){
					answer++
				}
			}
			else {
				count[i][j] = -1
			}
			
		}
	}
	
	println(answer)
}