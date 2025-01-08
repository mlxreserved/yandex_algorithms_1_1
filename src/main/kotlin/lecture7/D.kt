package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

const val START = -1
const val END = 1

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()

    val events = mutableListOf<Triple<Int, Int, Int>>()

    repeat(n) { pos ->
        val (i, o) = reader.readLine().trim().split(" ").map { it.toInt() }
        if (o - i >= 5) {
            events.add(Triple(i, START, pos))
            events.add(Triple(o - 5, END, pos))
        }
    }

    events.sortWith(
        compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }
    )



    if(events.size == 0){
        print("0 5 10")
    } else if(events.size == 1) {
        print("1 ${events[0].first} ${events[0].first + 5}")
    } else {
        var maxCount = 0
        var firstTime = 0
        var secondTime = 0
        val users = mutableSetOf<Int>()
        for (i in 0 until events.size) {
            if (events[i].second == START) {
                users.add(events[i].third)
                if(maxCount < users.size) {
                    maxCount = users.size
                    firstTime = events[i].first
                    secondTime = firstTime + 5
                }
            }

            var count = 0
            for(j in i + 1 until events.size) {
                if(events[j].second == START && events[j].third !in users) {
                    count++
                }
                if(events[j].first - events[i].first >= 5 && maxCount < users.size + count) {
                    maxCount = users.size + count
                    firstTime = events[i].first
                    secondTime = events[j].first
                }
                if(events[j].second == END && events[j].third !in users) {
                    count--
                }
            }

            if (events[i].second == END) {
                users.remove(events[i].third)
            }
        }

        print("${maxCount} ${firstTime} ${secondTime}")
    }
}