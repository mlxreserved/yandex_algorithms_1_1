package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{ it.toInt() }
    val nList = reader.readLine().trim().split(" ").map{ it.toLong() }
    val kList = reader.readLine().trim().split(" ").map{ it.toLong() }

    for(i in kList) {
        var l = 0
        var r = n - 1
        while(l < r) {
            val m = (l + r + 1) / 2
            if (nList[m] > i) {
                r = m - 1
            } else {
                l = m
            }
        }
        if(l != n - 1) {
            if (abs(nList[l] - i) > abs(nList[l + 1] - i)) {
                print("${nList[l + 1]}\n")
            } else {
                print("${nList[l]}\n")
            }
        } else {
            print("${nList[l]}\n")
        }
    }
}