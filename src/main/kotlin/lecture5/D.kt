package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, r) = reader.readLine().trim().split(" ").map{ it.toInt() }

    val d = reader.readLine().trim().split(" ").map{ it.toInt() }

    var first = 0
    var last = 0
    var count = 0L

    for(i in 0 until n) {
        while(last < n && d[last] - d[first] <= r) {
            last += 1
        }
        count += n - last
        first += 1
    }
    print(count)
}