package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

private const val START = -1
private const val END = 1

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val k = reader.readLine().toInt()

    for(i in 0 until k) {
        val string = reader.readLine().trim().split(" ").map { it.toInt() }

        val events = mutableListOf<List<Int>>()

        val n = string[0]
        for(j in 1 ..  2 * n step 2) {
            events.add(listOf(string[j], START, (j / 2 + 1)))
            events.add(listOf(string[j + 1], END, j / 2 + 1))
        }

        events.sortWith(compareBy<List<Int>> { it[0] }.thenBy { it[1] })


        println(events)



        for((time, event, pos) in events) {
            if(event == START) {
                 
            }
        }
    }
}