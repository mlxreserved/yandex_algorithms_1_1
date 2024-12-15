package lecture2

import java.io.*

fun main(){

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLines().toMutableList()

    val n = strings.removeFirst().toInt()

    val arrayOfNums = strings.removeFirst().split(" ").map { it.toInt() }.toMutableList()

    var winner = arrayOfNums[0]

    var possibleVasya = 0

    for(i in 1..n-2){
        val cur = arrayOfNums[i]
        if(winner < cur){
            winner = cur
            possibleVasya = 0
        } else if(cur%10==5 &&  possibleVasya < cur && cur>arrayOfNums[i+1]){
            possibleVasya = cur
        }
    }

    if(winner<arrayOfNums[n-1] || possibleVasya == 0){
        print(0)
    } else {
        arrayOfNums.apply {
            sort()
            reverse()
        }
        for(i in 0..n-1){
            if(arrayOfNums[i] == possibleVasya){
                print(i+1)
                break
            }
        }
    }

    input.close()
}