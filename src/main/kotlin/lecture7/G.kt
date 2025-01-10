package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

private const val START = -1
private const val END = 1


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (m, n) = reader.readLine().split(" ").map { it.toInt() }

    val events = mutableListOf<List<Int>>()

    for(i in 1 .. n) {
        val (t, z, y) = reader.readLine().split(" ").map { it.toInt() }
        var lastRest = 0
        for(j in 0 .. m/n) {
            events.add(listOf(lastRest, START, i, z))
            for(k in 1 .. z) {
                events.add(listOf(t * k + lastRest, END, i, 1))
            }
            lastRest += t * z + y
        }

    }

    events.sortWith(compareBy<List<Int>> { it[0] }.thenBy { it[1] })


    var t = 0
    val countForPeople = mutableMapOf<Int, Int>()
    var c = 0


    for((time, event, pos, count) in events) {
        if(event == END) {
            countForPeople[pos] = countForPeople.getOrDefault(pos, 0) + count
            c += count
            t = time
        }
        if(c == m) {
            break
        }
    }


    println(t)
    for(i in 1..n){
        print("${countForPeople.getOrDefault(i, 0)} ")
    }
}