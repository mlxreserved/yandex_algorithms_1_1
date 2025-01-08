package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

const val IN = -1
const val OUT = 1

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()

    val events = mutableListOf<Triple<Int, Int, Int>>()
    val workerPoint = mutableSetOf<Int>()

    repeat(n) { pos ->
        val (iHour, iMinute, oHour, oMinute) = reader.readLine().trim().split(" ").map { it.toInt() }
        val i = iHour * 60 + iMinute
        val o = oHour * 60 + oMinute
        if(i == o) {
            workerPoint.add(pos)
        } else {
            events.add(Triple(i, IN, pos))
            events.add(Triple(o, OUT, pos))
        }

    }

    events.sortWith(
        compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }
    )


    var lastOpen = 0

    for(i in events) {
        if(i.second == IN) {
            workerPoint.add(i.third)
            lastOpen = i.first
        } else {
            workerPoint.remove(i.third)
        }
    }

    var ans = 0

    for(i in events) {
        if(i.second == IN) {
            workerPoint.add(i.third)
            lastOpen = i.first
        } else {
            if(workerPoint.size == n) {
                ans += i.first - lastOpen
            }
            if(ans < 0) {
                ans += 24 * 60
            }
            workerPoint.remove(i.third)
        }
    }

    if(workerPoint.size == n && events.size == 0) {
        ans += 24 * 60
    }

    print(ans)
}