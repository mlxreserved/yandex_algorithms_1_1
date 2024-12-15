package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    val addedNum = strings.removeFirst().split("(",")","-").toMutableList().also { string ->
        if(string.size > 1 && string.joinToString("").length>7){
            string.removeFirst()
        } else if(string.size == 1){
            when (string[0].length) {
                11 -> {
                    string[0] = string[0].substring(1,string[0].length)
                }
                12 -> {
                    string[0] = string[0].substring(2,string[0].length)
                }
                else -> {
                    string.add(0,"495")
                }
            }
        } else {
            string.add(0,"495")
        }
    }.joinToString("")





    for(i in strings){
        val curNum = i.split("(",")","-").toMutableList().also{ string ->
            if(string.size > 1 && string.joinToString("").length>7){
                string.removeFirst()
            } else if(string.size == 1){
                when (string[0].length) {
                    11 -> {
                        string[0] = string[0].substring(1,string[0].length)
                    }
                    12 -> {
                        string[0] = string[0].substring(2,string[0].length)
                    }
                    else -> {
                        string.add(0,"495")
                    }
                }
            } else {
                string.add(0,"495")
            }
        }.joinToString("")

        if(curNum == addedNum){
            print("YES\n")
        } else {
            print("NO\n")
        }
    }




    reader.close()
}