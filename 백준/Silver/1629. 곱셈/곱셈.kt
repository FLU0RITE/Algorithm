import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var (a, b, c) = br.readLine().split(" ").map { it.toBigInteger() }

    bw.write("${solve(a,b,c)%c}\n")
    bw.flush()
}
fun solve(a: BigInteger, b: BigInteger,c:BigInteger): BigInteger {
    if (b==BigInteger.ONE) {
        return a*b
    }
    else {
        val k = solve(a,b/BigInteger("2"),c)
        if (b%BigInteger("2")==BigInteger.ZERO){
            return (k*k)%c
        } else {
            return (k*k*a)%c
        }
    }
}
