package lecture2

import java.io.*

fun main(args: Array<String>) {

    val input = BufferedReader(FileReader("input.txt"))

    val strings = input.readLines().toMutableList()

    val numbers = strings.removeFirst().split(" ")
    val n = numbers[0].toInt() // кол-во строк
    val m = numbers[1].toInt() // кол-во столбцов
    val k = numbers[2].toInt() // кол-во мин


    val mainList: MutableList<MutableList<String>> = ArrayList(MutableList(n) { MutableList(m) {"0"} })



    for(i in 0..k-1){
        val mine = strings.removeFirst().split(" ").map{it.toInt()}
        val a = mine[0] - 1
        val b = mine[1] - 1
        mainList[a][b] = "*"
        if(n-1>0 && m-1>0) {
            if (a == 0) {
                if (b == 0) {
                    if(mainList[a+1][b] != "*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b+1] != "*") {
                        mainList[a + 1][b + 1] = (mainList[a+1][b+1].toInt() + 1).toString()
                    }
                } else if(b == m-1){
                    if(mainList[a+1][b]!="*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1]!="*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b-1]!="*") {
                        mainList[a + 1][b - 1] = (mainList[a+1][b-1].toInt() + 1).toString()
                    }
                } else {
                    if(mainList[a+1][b] != "*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b+1] != "*") {
                        mainList[a + 1][b + 1] = (mainList[a+1][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1]!="*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b-1]!="*") {
                        mainList[a + 1][b - 1] = (mainList[a+1][b-1].toInt() + 1).toString()
                    }
                }
            } else if(a == n-1){
                if (b == 0) {
                    if(mainList[a-1][b] != "*") {
                        mainList[a - 1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b+1] != "*") {
                        mainList[a - 1][b + 1] = (mainList[a-1][b+1].toInt() + 1).toString()
                    }
                } else if(b == m-1){
                    if(mainList[a-1][b]!="*") {
                        mainList[a - 1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1]!="*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b-1]!="*") {
                        mainList[a - 1][b - 1] = (mainList[a-1][b-1].toInt() + 1).toString()
                    }
                } else {
                    if(mainList[a-1][b] != "*") {
                        mainList[a - 1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b+1] != "*") {
                        mainList[a - 1][b + 1] = (mainList[a-1][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1]!="*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b-1]!="*") {
                        mainList[a- 1][b - 1] = (mainList[a-1][b-1].toInt() + 1).toString()
                    }
                }
            } else {
                if (b == 0) {
                    if(mainList[a+1][b] != "*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b+1] != "*") {
                        mainList[a + 1][b + 1] = (mainList[a+1][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b] != "*"){
                        mainList[a-1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b+1] != "*"){
                        mainList[a-1][b+1] = (mainList[a-1][b+1].toInt() + 1).toString()
                    }
                } else if(b == m-1){
                    if(mainList[a+1][b] != "*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1] != "*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b-1] != "*") {
                        mainList[a + 1][b- 1] = (mainList[a+1][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b] != "*"){
                        mainList[a-1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b-1] != "*"){
                        mainList[a-1][b-1] = (mainList[a-1][b-1].toInt() + 1).toString()
                    }
                } else {
                    if(mainList[a+1][b] != "*") {
                        mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                    }
                    if(mainList[a][b-1] != "*") {
                        mainList[a][b - 1] = (mainList[a][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b-1] != "*") {
                        mainList[a + 1][b- 1] = (mainList[a+1][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b] != "*"){
                        mainList[a-1][b] = (mainList[a-1][b].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b-1] != "*"){
                        mainList[a-1][b-1] = (mainList[a-1][b-1].toInt() + 1).toString()
                    }
                    if(mainList[a][b+1] != "*") {
                        mainList[a][b + 1] = (mainList[a][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a+1][b+1] != "*") {
                        mainList[a + 1][b + 1] = (mainList[a+1][b+1].toInt() + 1).toString()
                    }
                    if(mainList[a-1][b+1] != "*"){
                        mainList[a-1][b+1] = (mainList[a-1][b+1].toInt() + 1).toString()
                    }
                }
            }
        } else if(n-1>0){
            if(a==0){
                if(mainList[a + 1][b] != "*") {
                    mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                }
            } else if(a == n-1){
                if(mainList[a-1][b] != "*"){
                    mainList[a-1][b] = (mainList[a-1][b].toInt() + 1).toString()
                }
            } else {
                if(mainList[a + 1][b] != "*") {
                    mainList[a + 1][b] = (mainList[a+1][b].toInt() + 1).toString()
                }
                if(mainList[a-1][b] != "*"){
                    mainList[a-1][b] = (mainList[a-1][b].toInt() + 1).toString()
                }
            }
        } else if(m-1>0){
            if(b==0){
                if(mainList[a][b+1] != "*") {
                    mainList[a][b+1] = (mainList[a][b+1].toInt() + 1).toString()
                }
            } else if(b == m-1){
                if(mainList[a][b-1] != "*"){
                    mainList[a][b-1] = (mainList[a][b-1].toInt() + 1).toString()
                }
            } else {
                if(mainList[a][b+1] != "*") {
                    mainList[a][b+1] = (mainList[a][b+1].toInt() + 1).toString()
                }
                if(mainList[a][b-1] != "*"){
                    mainList[a][b-1] = (mainList[a][b-1].toInt() + 1).toString()
                }
            }
        } else {
            mainList[0][0]="*"
        }
    }


    for(i in 0..n-1){
        for(j in 0..m-1){
            print("${mainList[i][j]} ")
        }
        print("\n")
    }



    input.close()

}