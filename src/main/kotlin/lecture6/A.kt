package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{ it.toInt() }
    val nList = reader.readLine().trim().split(" ").map { it.toInt() }
    val kList = reader.readLine().trim().split(" ").map { it.toInt() }

    for(i in kList) {
        var l = 0
        var r = n - 1
        var find = false
        while (l < r) {
            if(nList[(l + r) / 2] < i) {
                l = (l + r) / 2 + 1
            } else if( nList[(l + r) / 2] > i) {
                r = (l + r) / 2 - 1
            } else {
                find = true
                break
            }
        }
        if(find) {
            print("YES\n")
        } else if(r == l && nList[r] == i) {
            print("YES\n")
        } else {
            print("NO\n")
        }
    }
}

