package lecture4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var map = mutableMapOf<Int, Long>()

    val n = reader.readLine().toInt()
    for(i in 0 until n) {
        val (key, value) = reader.readLine().split(" ").map { it.toInt() }
        if(map.containsKey(key)){
            if(map[key]!! < value) {
                map[key] = value.toLong()
            }
        } else {
            map[key] = value.toLong()
        }
    }

    map = map.toSortedMap()
    print(map.values.sum())
}