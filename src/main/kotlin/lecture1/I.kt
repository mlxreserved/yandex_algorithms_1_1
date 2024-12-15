package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    var A = strings.removeFirst().toInt()
    var B = strings.removeFirst().toInt()
    var C = strings.removeFirst().toInt()
    val D = strings.removeFirst().toInt()
    val E = strings.removeFirst().toInt()

    if(A>B){
        val tempB = B
        B = A
        A = tempB
    }
    if(B>C){
        val tempC = C
        C = B
        B = tempC
    }

    if((A<=E && B <= D) || (A<=D && B <=E)){
        print("YES")
    } else {
        print("NO")
    }

    reader.close()
}