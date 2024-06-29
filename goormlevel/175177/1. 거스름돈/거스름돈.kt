import java.util.Scanner
fun main(args: Array<String>) {
	var input = readLine()!!.toInt()
	var count=0
	while(input!=0){
		input-=40
		if(input<0){
			input+=40
		}else{
			count++
			continue
		}
		input-=20
		if(input<0){
			input+=20
		}else{
			count++
			continue
		}
		input-=10
		if(input<0){
			input+=10
		}else{
			count++
			continue
		}
		input-=5
		if(input<0){
			input+=5
		}else{
			count++
			continue
		}
		input-=1
		count++
	}
	println(count)
}