package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLine()!!.split(" ").toMutableList()

    var N = strings.removeFirst().toInt()
    val K = strings.removeFirst().toInt()
    val M = strings.removeFirst().toInt()
    var countZag = 0
    var countDet = 0
    var ostDet = 0

    while(N>=K){
        countZag = N/K
        N %= K
        for(i in 1..countZag){
            countDet += K/M
            N+= K%M
        }
        if(M>K){
            break
        }
    }

    print(countDet)

    reader.close()
}