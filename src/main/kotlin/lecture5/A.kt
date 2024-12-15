package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val firstArray = reader.readLine().trim().split(" ").map{ it.toLong() }
    val m = reader.readLine().trim().toInt()
    val secondArray = reader.readLine().trim().split(" ").map{ it.toLong() }

    var minDiff = max(firstArray.last(), secondArray.last()) + 1

    var resPair = Pair(firstArray[0], secondArray[0])

    var first = 0
    var second = 0

    while(first < n && second < m) {
        if(firstArray[first] - secondArray[second] == 0L) {
            resPair = Pair(firstArray[first], secondArray[second])
            break
        } else if (abs(firstArray[first] - secondArray[second]) < minDiff) {
            minDiff = abs(firstArray[first] - secondArray[second])
            resPair = Pair(firstArray[first], secondArray[second])
        }

        if(firstArray[first] > secondArray[second]) {
            second += 1
        } else if(secondArray[second] > firstArray[first]) {
            first += 1
        } else break
    }

    print("${resPair.first} ${resPair.second}")
}