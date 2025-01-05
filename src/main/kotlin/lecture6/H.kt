package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{ it.toInt() }

    val arr: MutableList<Int> = mutableListOf()

    repeat(n) {
        arr.add(reader.readLine().trim().toInt())
    }

    var l = 0
    var r = arr.max()

    while(l < r) {
        val m = (l + r + 1) / 2
        if(check(m, k, arr)) {
            l = m
        } else {
            r = m - 1
        }
    }

    print(r)
}

fun check(m: Int, k: Int, arr: List<Int>): Boolean {

    var count = 0
    for(length in arr) {
        count += length / m
    }
    return count >= k

}

