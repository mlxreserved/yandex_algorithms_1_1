package lecture4

import java.io.BufferedReader
import java.io.FileReader


fun main() {
    val input = BufferedReader(FileReader("input.txt"))
    val map = mutableMapOf<String, Int>()

    for(string in input.readLines().filter{ it!="" }) {
        for(word in string.trim().split("\\s+".toRegex())){
            map[word] = map[word]?.plus(1) ?: 0
            print("${map[word]} ")
        }
    }
}