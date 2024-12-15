package lecture1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val strings = reader.readLines().toMutableList()

    var a = strings.removeFirst().toDouble()
    var b = strings.removeFirst().toDouble()
    var c = strings.removeFirst().toDouble()
    val d = strings.removeFirst().toDouble()
    val e = strings.removeFirst().toDouble()
    val f = strings.removeFirst().toDouble()

    Kramer(a,b,c,d,e,f)

    reader.close()
}

fun Kramer(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double){
    val x: Double
    val y: Double

    val det = a*d - b*c
    val detx = e*d - f*b
    val dety = a*f - c*e

    if(det == 0.0) {
        if(abs(a) + abs(b) + abs(c) + abs(d) == 0.0){
            if(abs(e) + abs(f) == 0.0) print(5)
            else print(0)
        }
        else if((abs(detx) > 0) || (abs(dety) > 0)) print(0)
        else if(b == 0.0){
            if(abs(a) > 0) print("3 ${e/a}")
            else if(abs(d) == 0.0) print("3 ${f/c}")
            else if(abs(c) == 0.0) print("4 ${f/d}")
            else print("1 ${-c/d} ${f/d}")
        }
        else if(a==0.0){
            if(abs(b) > 0) print("4 ${e/b}")
            else if(abs(d) == 0.0) print("3 ${f/c}")
            else if(abs(c) == 0.0) print("4 ${f/d}")
            else print("1 ${-c/d} ${f/d}")
        }
        else print("1 ${-a/b} ${e/b}")
    } else {
        x=detx/det
        y=dety/det
        print("2 $x $y")
    }

}