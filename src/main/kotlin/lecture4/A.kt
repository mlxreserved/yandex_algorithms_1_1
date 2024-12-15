package lecture4

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val map = mutableMapOf<String, String>()
    for(i in 0 until n) {
        val (word, syn) = reader.readLine().split(" ")
        map[word] = syn
    }

    val word = reader.readLine()
    if(map.containsKey(word)) {
        print(map[word])
    } else {
        for(i in map.keys) {
            if(map[i] == word) {
                print(i)
            }
        }
    }
}