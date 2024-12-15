package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    val a = strings.removeFirst().toInt()
    val b = strings.removeFirst().toInt()
    val n = strings.removeFirst().toInt()
    val m = strings.removeFirst().toInt()

    val min1 = a*(n-1) + n
    val max1 = a*(n+1) + n

    val min2 = b*(m-1) + m
    val max2 = b*(m+1) + m

    val minans = max(min1,min2)
    val maxans = min(max1,max2)

    if(minans>maxans){
        print(-1)
    } else {
        print("$minans $maxans")
    }

    reader.close()
}