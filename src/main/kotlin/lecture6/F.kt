package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, x, y) = reader.readLine().trim().split(" ").map { it.toLong() }

    val total = min(x, y)
    var r = max(x, y) * (n - 1)
    var l = 0L

    while (l < r){
        val m = (l + r) / 2
        if((m / x + m / y) >= n - 1) {
            r = m
        } else {
            l = m + 1
        }

    }
    print(l + total)
}


