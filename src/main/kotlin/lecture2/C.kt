package lecture2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    val n = strings.removeFirst().toInt()

    val arrayOfNums = strings.removeFirst().split(" ").toMutableList().map { it.toInt() }.sorted()

    val x = strings.removeFirst().toInt()

    var start = 0
    var end = n - 1
    var cur = arrayOfNums[end/2]


    while(cur != x){


        if(x > cur){
            start = (end+start)/2+1
            cur = arrayOfNums[(end+start)/2]
        } else {
            end = (end+start)/2-1
            cur = arrayOfNums[(end+start)/2]
        }
        if(start>end){
            if(start!=n && end!=-1){
                if(arrayOfNums[start]-x > x-arrayOfNums[end]){
                    cur = arrayOfNums[end]
                } else {
                    cur = arrayOfNums[start]
                }
            }
            break
        }
    }
    print(cur)


    reader.close()
}