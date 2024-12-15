package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val list = reader.readLine().split(" ").toSet()

    print(list.size)
}