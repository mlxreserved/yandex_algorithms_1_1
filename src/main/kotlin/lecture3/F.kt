package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val a = reader.readLine()
    val b = reader.readLine()

    val setMin = mutableSetOf<String>()
    var ans = 0L

    for(i in 0 until b.length-1) {
        setMin += "${b[i]}${b[i+1]}"
    }
    for(i in 0 until a.length-1) {
        if("${a[i]}${a[i+1]}" in setMin) {
            ans+=1
        }
    }

    print(ans)
}