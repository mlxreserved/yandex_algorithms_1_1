package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val classP = reader.readLine().split(" ").map{ it.toInt() }

    val m = reader.readLine().toInt()

    val map = mutableMapOf<Long, Long>()

    repeat(m) {
        val (p, cost) = reader.readLine().split(" ").map{ it.toLong()}
        if(map.containsKey(p)){
            map[p] = min(cost, map[p]!!)
        } else {
            map[p] = cost
        }
    }

    val sortedMap = map.toList()
        .sortedBy{ (_, value) -> value}
        .toMap()

    val listKeys = sortedMap.keys.toList()

    var sum = 0L

    for(i in 0 until n){
        for(j in 0 until listKeys.size){
            if(listKeys[j] >= classP[i]) {
                sum += sortedMap[listKeys[j]]!!
                break
            }
        }
    }


    print(sum)
}