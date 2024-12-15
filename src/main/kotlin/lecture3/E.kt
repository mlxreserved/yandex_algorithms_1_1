package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (a, b, c) = reader.readLine().trim().split(" ").map{ it.toInt() }
    val setOfEl = mutableSetOf(a, b, c)
    var res = reader.readLine().toInt()
    while(res != 0) {
        val ost = res % 10
        setOfEl.add(ost)
        res /= 10
    }
    print(setOfEl.size-3)

    reader.close()
}