package lecture6

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val a = reader.readLine().trim().toLong()
    val b = reader.readLine().trim().toLong()
    val c = reader.readLine().trim().toLong()

    var l = 0L
    val countAssessment = a + b + c
    var r = countAssessment

    while(l < r){
        val m = (l + r) / 2

        if(2 * (2 * a + 3 * b + 4 * c + 5 * m) < 7 * (m + countAssessment)) {
            l = m + 1
        } else {
            r = m
        }
    }

    print(l)
}