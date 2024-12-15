package org.example.lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    val a = strings.removeFirst().toInt()
    val b = strings.removeFirst().toInt()
    val c = strings.removeFirst().toInt()

    if((a < b + c) && (b < a + c) && (c < b + a)){
        print("YES")
    } else {
        print("NO")
    }

    reader.close()
}