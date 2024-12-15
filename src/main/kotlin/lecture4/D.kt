package lecture4

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<Int, Int>()

    val n = reader.readLine().toInt()
    val clicks = reader.readLine().trim().trim().split("\\s+".toRegex()).map { it.toInt() }
    for(i in 1..n) {
        map[i] = clicks[i-1]
    }

    val k = reader.readLine().toInt()
    val buttons = reader.readLine().trim().split("\\s+".toRegex()).map { it.toInt() }
    for(i in 0 until k) {
        map[buttons[i]] = map[buttons[i]]!! - 1
    }

    for(i in map.values) {
        if(i >= 0){
            print("NO\n")
        } else {
            print("YES\n")
        }
    }
}