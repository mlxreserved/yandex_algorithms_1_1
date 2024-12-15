package lecture2

import java.io.*

fun main(){

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLine()!!.split(" ").toMutableList()
    if(strings[0] == ""){
        strings.removeFirst()
    }

    var min1 = 0
    var min2 = 1
    var max1 = 0
    var max2 = 1

    for (i in 2..strings.size - 1) {
        if (strings[i] != "") {
            if (strings[i].toLong() < strings[min1].toLong()) {
                if(strings[min2].toLong()>strings[min1].toLong()) {
                    min2 = min1
                }
                min1 = i
            }else if (strings[i].toLong() < strings[min2].toLong()) {
                min2 = i
            }
            if (strings[i].toLong() > strings[max1].toLong()) {
                if(strings[max2].toLong()<strings[max1].toLong()){
                    max2 = max1
                }
                max1 = i
            }else if (strings[i].toLong() > strings[max2].toLong()) {
                max2 = i
            }
        }
    }

    if(max1 == max2 && max2 == min1 && min1 == min2){
        if(strings[max2].toLong()>strings[max1].toLong()){
            print("${strings[max1]} ${strings[max2]}")
        } else {
            print("${strings[max2]} ${strings[max1]}")
        }
    } else if((max1 == max2 && max2==min2) || (max2 == min2 && min2==min1)){
        if(strings[max1].toLong()>strings[min1].toLong()) {
            print("${strings[min1]} ${strings[max1]}")
        } else {
            print("${strings[max1]} ${strings[min1]}")
        }
    } else if(max1==max2){
        if(strings[max1].toLong()*strings[min1].toLong() > strings[max1].toLong()*strings[min2].toLong()){
            if(strings[min1].toLong()>strings[max1].toLong()){
                print("${strings[max1]} ${strings[min1]}")
            } else {
                print("${strings[min1]} ${strings[max1]}")
            }
        } else {
            if(strings[min2].toLong()>strings[max1].toLong())
            {
                print("${strings[max1]} ${strings[min2]}")
            } else {
                print("${strings[min2]} ${strings[max1]}")
            }
        }
    } else {
        if(strings[min1].toLong()*strings[min2].toLong() > strings[max1].toLong()*strings[max2].toLong()){
            if(strings[min1].toLong()>strings[min2].toLong()){
                print("${strings[min2]} ${strings[min1]}")
            } else {
                print("${strings[min1]} ${strings[min2]}")
            }
        } else {
            if(strings[max1].toLong()>strings[max2].toLong()) {
                print("${strings[max2]} ${strings[max1]}")
            } else {
                print("${strings[max1]} ${strings[max2]}")
            }
        }
    }

    input.close()
}