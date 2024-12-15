package lecture4

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    //val reader = BufferedReader(InputStreamReader(System.`in`))
    val input = BufferedReader(FileReader("input.txt"))
    val map = mutableMapOf<String, Int>()

    for(string in input.readLines()) {
        for(word in string.trim().split(" ")){
            map[word] = map[word]?.plus(1) ?: 1
        }
    }

    val max = map.values.max()
    for(word in map.toSortedMap().keys){
        if(map[word] == max) {
            print(word)
            break
        }
    }
}