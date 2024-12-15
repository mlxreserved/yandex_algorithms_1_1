package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.FileReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val xSet = mutableSetOf<Int>()

    for(i in 0 until n) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        xSet += x
    }

    print(xSet.size)
}