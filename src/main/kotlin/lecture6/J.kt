package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, l) = reader.readLine().trim().split(" ").map{ it.toInt() }

    val arr: MutableList<List<Int>> = mutableListOf()

    repeat (n) {
        arr.add(reader.readLine().trim().split(" ").map { it.toInt() })
    }

    for(i in 0 until n){
        for(j in i + 1 until n) {
            val newArr = (arr[i] + arr[j]).sorted()
            print("${newArr[l - 1]}\n")
        }
    }
}