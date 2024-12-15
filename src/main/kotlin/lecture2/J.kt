package lecture2

import java.io.*
import kotlin.math.*
import java.lang.Math.pow

fun main(args: Array<String>) {

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLines().toMutableList()

    val numbers = strings.removeFirst().toInt() - 1

    var firstNote = strings.removeFirst().toDouble()

    var max: Double = 4000.0
    var min: Double = 30.0

    for(i in 0 until numbers){
        val item = strings.removeFirst().split(" ")
        if(abs(item[0].toDouble()-firstNote)>pow(10.0,-6.0)){
            if(item[1] == "further"){
                if(item[0].toDouble()<firstNote){
                    min = max(min, (item[0].toDouble() + firstNote) / 2)
                } else {
                    max = min(max, (item[0].toDouble() + firstNote) / 2)
                }
            } else {
                if(item[0].toDouble()>firstNote){
                    min = max(min, (item[0].toDouble() + firstNote) / 2)
                } else {
                    max = min(max, (item[0].toDouble() + firstNote) / 2)
                }
            }
            firstNote = item[0].toDouble()
        }
    }


    print("$min $max")

    input.close()

}