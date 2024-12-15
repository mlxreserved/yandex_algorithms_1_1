package lecture2

import java.io.*

fun main(){

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLines().toMutableList()

    val n = strings.removeFirst().toInt()

    val seq: MutableList<Int>
    val string: String = strings.removeFirst()
    if(string[0] == ' '){
        seq = string.substring(1,string.length).split(" ").map{ it.toInt() }.toMutableList()
    } else if( string[string.length-1] == ' '){
        seq = string.substring(0, string.length-1).split(" ").map{ it.toInt() }.toMutableList()
    } else{
        seq = string.split(" ").map{ it.toInt() }.toMutableList()
    }
    var reversedSeq: MutableList<Int> = seq.reversed().toMutableList()

    var deletedItems: MutableList<Int> = mutableListOf()

    while(seq!=reversedSeq){
        deletedItems.add(seq.removeFirst())
        reversedSeq.removeLast()
    }

    if(deletedItems.size==0){
        print(0)
    } else {
        print("${deletedItems.size}\n")
        print(deletedItems.reversed().joinToString(" "))
    }

    input.close()
}