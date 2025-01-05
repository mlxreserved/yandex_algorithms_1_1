package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (w, h, n) = reader.readLine().trim().split(" ").map { it.toLong() }

    var l = min(w, h)
    var r = max(w, h) * n

    while(l < r) {
        val m = (l + r) / 2
        val res = (m / w) * (m / h)
        if(n > res) {
            l = m + 1
        } else {
            r = m
        }
    }
    print(r)
}