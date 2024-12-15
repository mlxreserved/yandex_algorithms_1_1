package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k)= reader.readLine().trim().split(" ").map{ it.toInt() }

    val array = reader.readLine().trim().split(" ").map{ it.toInt() }

    var first = 0
    var last = 0
    var count = 0
    var sums = 0

    while(first < n) {
        if(last == first && array[last] == k) {
            count += 1
            first += 1
            last += 1
        } else {
            if(sums < k && last < n) {
                sums += array[last]
                last += 1
            } else if (sums > k) {
                sums -= array[first]
                first += 1
            } else {
                if(sums == k) {
                    count++
                }
                sums -= array[first]
                first += 1

            }

        }
    }


    print(count)
}