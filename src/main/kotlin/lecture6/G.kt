package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toLong()
    val m = reader.readLine().trim().toLong()
    val t = reader.readLine().trim().toLong()

    var l = 0L
    var r = min(n / 2, m / 2)

   while(l < r) {
       val mid = (l + r + 1) / 2
       val s = ((n * mid) + (m * mid)) * 2 - 4 * mid * mid
       if(t - s >= 0) {
           l = mid
       } else {
           r = mid - 1
       }
   }
    print(r)
}