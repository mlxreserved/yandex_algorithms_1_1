package lecture2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    var constant = true
    var ascending = true
    var weaklyAscending = true
    var descending = true
    var weaklyDescending = true

    for(i in 0..strings.size-3){
        if(strings[i].toInt()==strings[i+1].toInt()){
            descending = false
            ascending = false
        } else if(strings[i].toInt()>strings[i+1].toInt()){
            constant = false
            ascending = false
            weaklyAscending=false
        } else if(strings[i].toInt()<strings[i+1].toInt()){
            constant=false
            descending = false
            weaklyDescending=false
        }
    }

    if(constant){
        print("CONSTANT")
    } else if(descending){
        print("DESCENDING")
    } else if(ascending){
        print("ASCENDING")
    } else if(weaklyAscending){
        print("WEAKLY ASCENDING")
    } else if(weaklyDescending){
        print("WEAKLY DESCENDING")
    } else {
        print("RANDOM")
    }

    reader.close()
}