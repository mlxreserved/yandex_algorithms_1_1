package lecture2

import java.io.*

fun main(){

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLine()!!.split(" ").toMutableList()
    if(strings[0] == ""){
        strings.removeFirst()
    }

    var maxArr = mutableListOf(strings[0].toLong(), strings[1].toLong(), strings[2].toLong()).sorted().toMutableList()
    var minArr = mutableListOf(strings[0].toLong(), strings[1].toLong(), strings[2].toLong()).sorted().toMutableList()

    for(i in 3..strings.size-1){
        if(strings[i]!="") {
            if (maxArr.min()!! < strings[i].toLong()) {
                maxArr.removeFirst()
                if(strings[i].toLong()>maxArr[1]) {
                    maxArr.add(strings[i].toLong())
                } else if(strings[i].toLong()>maxArr[0]){
                    maxArr.add(1,strings[i].toLong())
                } else {
                    maxArr.add(0,strings[i].toLong())
                }
            }
            if (minArr.max()!! > strings[i].toLong()) {
                minArr.removeLast()
                if(strings[i].toLong()<minArr[0]) {
                    minArr.add(0, strings[i].toLong())
                } else if(strings[i].toLong()<minArr[1]){
                    minArr.add(1,strings[i].toLong())
                } else {
                    minArr.add(strings[i].toLong())
                }
            }
        }
    }

    if(minArr[0]*minArr[1]*maxArr[2]>maxArr[0]*maxArr[1]*maxArr[2]){
        print("${minArr[0]} ${minArr[1]} ${maxArr[2]}")
    } else {
        print("${maxArr[0]} ${maxArr[1]} ${maxArr[2]}")
    }


    input.close()
}