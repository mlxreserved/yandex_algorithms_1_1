package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = reader.readLine().trim().split(" ").map { it.toInt() } // n - количество отрезков, m - количество точек

    val events = mutableListOf<Pair<Long, Long>>()

    repeat(n) {
        val(i, o) = reader.readLine().trim().split(" ").map { it.toLong() }
        if(i < o) {
            events.add(Pair(i, -1))
            events.add(Pair(o, 1))
        } else {
            events.add(Pair(i, 1))
            events.add(Pair(o, -1))
        }
    }

    val dots = reader.readLine().trim().split(" ").map { it.toLong() }
    dots.forEach {
        events.add(Pair(it, 0))
    }

    events.sortWith(
        compareBy<Pair<Long, Long>> { it.first }.thenBy { it.second }
    )


    var counter = 0L
    val dotsMap = mutableMapOf<Long, Long>()

    for(i in events) {
        when (i.second) {
            -1L -> {
                counter++
            }
            0L -> {
                dotsMap[i.first] = counter
            }
            else -> {
                counter--
            }
        }
    }
    for(i in dots) {
        print("${dotsMap[i]} ")
    }
}