package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLine()!!.split(" ").toMutableList()

    val a1 = strings.removeFirst().toInt()
    val b1 = strings.removeFirst().toInt()
    val a2 = strings.removeFirst().toInt()
    val b2 = strings.removeFirst().toInt()

    var minSize = Int.MAX_VALUE
    var minA = Int.MAX_VALUE
    var minB = Int.MAX_VALUE

    if( (a1+a2) * max(b1,b2) < minSize) {
        minSize = (a1 + a2) * max(b1, b2)
        minA = (a1 + a2)
        minB = max(b1, b2)
    }
    if ((a1+b2) * max(a2,b1) < minSize) {
        minSize = (a1 + b2) * max(a2, b1)
        minA = (a1 + b2)
        minB = max(a2, b1)
    }
    if((b1+a2) * max(a1,b2)<minSize){
        minSize = (b1+a2) * max(a1,b2)
        minA = (b1+a2)
        minB = max(a1,b2)
    }
    if((b1+b2) * max(a1,a2)< minSize){
        minSize = (b1+b2)* max(a1,a2)
        minA = (b1+b2)
        minB = max(a1,a2)
    }

    print("$minA $minB")
    reader.close()
}