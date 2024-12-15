package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val all = mutableSetOf<String>()
    var union = mutableSetOf<String>()

    for(i in 0 until n) {
        val m = reader.readLine().toInt()
        val a = mutableSetOf<String>()
        for(j in 0 until m) {
            a += reader.readLine()
        }
        all += a
        if(i == 0) {
            union.addAll(a)
        } else {
            union = (union intersect a).toMutableSet()
        }
    }
    print("${union.size}\n")
    print(union.joinToString("\n"))
    print("\n${all.size}\n")
    print(all.joinToString("\n"))
}