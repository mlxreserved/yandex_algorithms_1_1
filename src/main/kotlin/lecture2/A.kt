package lecture2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLine()!!.split(" ").toMutableList()

    var fl: Boolean = true

    for(i in 0..strings.size-2){
        if(strings[i].toInt()>=strings[i+1].toInt()){
            fl = false
        }
    }

    if(fl){
        print("YES")
    }
    else{
        print("NO")
    }
    reader.close()
}