package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    print((reader.readLine().split(" ").map{ it.toLong() }.toSet() intersect reader.readLine().split(" ").map{ it.toLong() }.toSet()).sorted().joinToString(" "))
}
