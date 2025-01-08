package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = reader.readLine().trim().split(" ").map { it.toInt() }

    var count = 0
    val events = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (i, o) = reader.readLine().trim().split(" ").map { it.toInt() }
        events.add(Pair(i, -1))
        events.add(Pair(o, 1))
    }

    events.sortWith(
        compareBy<Pair<Int, Int>> {it.first}.thenBy { it.second }
    )

    var current = 0
    var firstEnter = -1
    for(i in 0 until events.size) {
        if(events[i].second == -1) {
            if(firstEnter == -1){
                firstEnter = events[i].first
            }
            current += 1
        } else {
            current -= 1
        }
        if(current == 0 && firstEnter != -1) {
            count += events[i].first - firstEnter + 1
            firstEnter = -1
        }
    }

    print(n - count)
}