package lecture3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))


    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val anya = mutableSetOf<Int>()
    val borya = mutableSetOf<Int>()

    for(i in 0 until n) {
        anya.add(reader.readLine().toInt())
    }
    for(i in 0 until m) {
        borya.add(reader.readLine().toInt())
    }
    val together = (anya intersect borya).sorted()
    print("${together.size}\n")
    print(together.joinToString(" "))

    val anyaWithoutBorya = (anya subtract borya).sorted()
    print("\n${anyaWithoutBorya.size}\n")
    print(anyaWithoutBorya.joinToString(" "))

    val boryaWithotAnya = (borya subtract anya).sorted()
    print("\n${boryaWithotAnya.size}\n")
    print(boryaWithotAnya.joinToString(" "))
}