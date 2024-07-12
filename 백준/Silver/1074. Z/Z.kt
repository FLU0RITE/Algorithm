import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val pow = sc.nextInt()
    var n = 1
    for (i in 1..pow) {
        n *= 2
    }
    val r = sc.nextInt()
    val c = sc.nextInt()

    println(z(n, r, c))
}

fun z(n: Int, r: Int, c: Int): Int {
    if (n == 1) {
        return 0
    }
    if (r >= n / 2 && c >= n / 2) {
        return z(n / 2, r - n / 2, c - n / 2) + n * n / 2 + n * n / 4
    } else if (r >= n / 2 && c < n / 2) {
        return z(n / 2, r - n / 2, c) + n * n / 2
    } else if (r < n / 2 && c >= n / 2) {
        return z(n / 2, r, c - n / 2) + n * n / 4
    } else if (r < n / 2 && c < n / 2) {
        return z(n / 2, r, c)
    } else {
        return 0
    }
}
