package lecture2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLine()!!.split(" ").toMutableList()

    var count = 0

    for(i in 1..strings.size-2){
        if(strings[i-1].toInt()<strings[i].toInt() && strings[i+1].toInt()<strings[i].toInt()){
            count+=1
        }
    }

    print(count)

    reader.close()
}