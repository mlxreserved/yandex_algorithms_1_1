package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()

    val ups = mutableListOf<Int>()

    for (i in 0 until n) {
        val (x, y) = reader.readLine().trim().split(" ").map { it.toInt() }
        ups.add(y)
    }

    val prefixsumsups = mutableListOf(0, ups[0])
    val postfixsumsups = mutableListOf(0, ups.last())

    for(i in 1 until n) {
        if(ups[i] > ups[i - 1]) {
            prefixsumsups.add(prefixsumsups.last() + ups[i] - ups[i - 1])
        } else {
            prefixsumsups.add(prefixsumsups.last())
        }
        if(ups[i - 1] > ups[i]) {
            postfixsumsups.add(postfixsumsups.last() + ups[i - 1] - ups[i])
        } else {
            postfixsumsups.add(postfixsumsups.last())
        }
    }

    val m = reader.readLine().trim().toInt()
    for(i in 0 until m) {
        val (s, f) = reader.readLine().trim().split(" ").map { it.toInt() }
        if(s > f) {
            print(if(postfixsumsups[s] > postfixsumsups[f]) postfixsumsups[s] - postfixsumsups[f] else 0)
            print("\n")
        } else {
            print(if(prefixsumsups[f] > prefixsumsups[s]) prefixsumsups[f] - prefixsumsups[s] else 0)
            print("\n")
        }
    }
}