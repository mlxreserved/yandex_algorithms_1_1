package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, a, b, w, h) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }

    var l = 0L
    var r = max(w, h)

    while(l < r) {
        val m = (l + r + 1) / 2
        val moduleA = (a + 2 * m)
        val moduleB = (b + 2 * m)
        val res = max((w / moduleA) * (h / moduleB), (w / moduleB) * (h / moduleA))
        if(res < n) {
            r = m - 1
        } else {
            l = m
        }
    }

    print(r)
}