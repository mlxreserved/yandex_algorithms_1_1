package lecture4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<String, MutableSet<String>>()
    val n = reader.readLine().trim().toInt()


    for(i in 0 until n) {
        val el = reader.readLine()
        val elLower = el.toLowerCase()
        if(elLower !in map.keys) {
            map[elLower] = mutableSetOf()
        }
        map[elLower]!!.add(el)

    }

    var count = 0

    val words = reader.readLine().split(" ")
    words.forEach { word ->
        val wordLower = word.toLowerCase()
        var countUpper = 0
        for(c in word) {
            if(c.isUpperCase()){
                countUpper++
            }
        }
        if(((wordLower in map.keys && !map[wordLower]!!.contains(word)) || countUpper != 1) && word.isNotBlank()) {
            count++
        }
    }
    print(count)

}