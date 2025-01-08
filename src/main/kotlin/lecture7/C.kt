package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader

const val CAN_SPEAK = -1
const val CAN_NOT_SPEAK = 1

fun main() {


    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, d) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toInt() }

    val xList = reader.readLine().trim().split("\\s+".toRegex()).map { it.toInt() }

    val events = mutableListOf<Pair<Int, Int>>()

    for(i in xList){
        events.add(Pair(i, CAN_SPEAK))
        events.add(Pair(i + d, CAN_NOT_SPEAK))
    }

    events.sortWith(
        compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
    )

    var count = 0
    var maxCount = 0
    for(i in events){
        if(i.second == CAN_SPEAK) {
            count += 1
            if(count > maxCount) {
                maxCount = count
            }
        } else {
            count -= 1
        }
    }

    val map = mutableMapOf<Int, Int>()

    var variant = 1

    for(i in events) {
        if(i.second == CAN_SPEAK) {
            map[i.first] = variant
            if(variant < maxCount) {
                variant += 1
            } else {
                variant = 1
            }
        }
    }

    print("${map.values.max()}\n")
    for(i in xList) {
        print("${map[i]} ")
    }
}