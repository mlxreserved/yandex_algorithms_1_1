package org.example.lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (tRoom, tCond) = reader.readLine().trim().split(" ").map { it.toInt() }

    val mode = reader.readLine().trim()

    if(mode == "freeze"){
        if(tRoom<=tCond){
            print(tRoom)
        } else {
            print(tCond)
        }
    } else if(mode == "heat"){
        if(tRoom>=tCond){
            print(tRoom)
        } else {
            print(tCond)
        }
    } else if(mode == "fan"){
        print(tRoom)
    } else {
        print(tCond)
    }

    reader.close()
}