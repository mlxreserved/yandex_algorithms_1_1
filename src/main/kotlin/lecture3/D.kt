package lecture3

import java.io.BufferedReader
import java.io.FileReader

fun main(){
    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLines()

    val set = mutableSetOf<String>()

    for(string in strings) {
        if(string != "") {
            string.trim().split(" ").forEach { set.add(it) }
        }
    }

    print(set.size)
}