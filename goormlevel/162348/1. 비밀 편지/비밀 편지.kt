import java.util.Scanner
fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val num = sc.nextInt()
	sc.nextLine()
	repeat(num){
		val ans = StringBuilder()
		val s = sc.nextLine()
		val command = sc.next()
		val p = sc.next()
		sc.nextLine()
		
		if (command == "E"){
			for (i in 0 until s.length){
				if (s[i]==' ')
					ans.append(' ')
				else if(s[i].isUpperCase()){
					ans.append('A' + (s[i].toInt() + p[i%p.length].toInt() - 'A'.toInt()) % 26)
				}
				else if(s[i].isLowerCase()){
					ans.append('a' + (s[i].toInt() + p[i%p.length].toInt() - 'a'.toInt()) % 26)
				}
				else{
					ans.append(s[i])
				}
			}
		}
		else if(command == "D"){
			for (i in 0 until s.length){
				if (s[i]==' ')
					ans.append(' ')
				else if(s[i].isUpperCase()){
					var a = (s[i].toInt() - p[i%p.length].toInt()%26 +26 - 'A'.toInt())
					
					ans.append('A' +  a % 26)
				}
				else if(s[i].isLowerCase()){
					var a = (s[i].toInt() - p[i%p.length].toInt()%26 +26 - 'a'.toInt())
					
					ans.append('a' +  a % 26)
				}
				else{
					ans.append(s[i])
				}
			}
		}
		println(ans)
	}
}