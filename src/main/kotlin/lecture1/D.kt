package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    val a = strings.removeFirst().toInt()
    val b = strings.removeFirst().toInt()
    val c = strings.removeFirst().toInt()

    if(c>=0){
        if(a == 0) {
            if(b!=c*c){
                print("NO SOLUTION")
            } else {
                print("MANY SOLUTIONS")
            }
        } else {
            if((c*c - b)%a == 0) {
                print((c * c - b) / a)
            } else {
                print("NO SOLUTION")
            }
        }
    } else {
        print("NO SOLUTION")
    }

    reader.close()
}