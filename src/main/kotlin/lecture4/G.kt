package lecture4

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    //val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = BufferedReader(FileReader("input.txt"))
    var map = mutableMapOf<String, Long>()


    input.useLines { lines ->
        lines.forEach { line ->
            val s = line.split(" ")
            if(s[0] == "DEPOSIT") {
                map[s[1]] = map.getOrDefault(s[1], 0) + s[2].toLong()
            } else if (s[0] == "WITHDRAW") {
                map[s[1]] = map.getOrDefault(s[1], 0) - s[2].toLong()
            } else if (s[0] == "BALANCE") {
                print("${map[s[1]] ?: "ERROR"}\n")
            } else if (s[0] == "TRANSFER") {
                map[s[2]] = map.getOrDefault(s[2], 0) + s[3].toLong()
                map[s[1]] = map.getOrDefault(s[1],0) - s[3].toLong()
            } else if (s[0] == "INCOME") {
                map = map.mapValues { if(it.value > 0) it.value + (s[1].toLong() * it.value)/100 else it.value}.toMutableMap()
            }
        }
    }
}