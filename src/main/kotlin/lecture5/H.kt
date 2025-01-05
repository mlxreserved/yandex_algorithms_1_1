package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{ it.toInt() }
    val a = reader.readLine().trim()

    var l = 0
    var r = 1
    var first = l
    var maxLength = 0


    val list = MutableList(26) {0}


    if(n == 1) {
        print("1 1")
    } else {
        list[a[l] - 'a'] += 1
        while(r < n) {
            list[a[r] - 'a'] += 1
            if(list.sum() > maxLength && list[a[r] - 'a'] <= k) {
                maxLength = list.sum()
                first = l + 1
            }
            while(list[a[r] - 'a'] > k) {
                list[a[l] - 'a'] -= 1
                l++
            }
            r++
        }
        print("$maxLength $first")
    }
//    if(n == 1){
//        list[a[l] - 'a'] += 1
//        maxLength = 1
//        first = l + 1
//    } else {
//        list[a[l] - 'a'] += 1
//        while(l < n && r < n) {
//            if(list[a[r] - 'a'] + 1 > k) {
//                if(list.sum() > maxLength) {
//                    maxLength = list.sum()
//                    first = l + 1
//                }
//                list[a[l] - 'a'] -= 1
//                l++
//            } else {
//                list[a[r] - 'a'] += 1
//                r++
//            }
//        }
//    }
//
//
//    print("$maxLength $first")
}