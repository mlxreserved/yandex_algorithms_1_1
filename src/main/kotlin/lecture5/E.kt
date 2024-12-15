package lecture5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{ it.toInt() }

    val a = reader.readLine().trim().split(" ")

    var n_tmp = n

    val d = a.associateBy({it}, {0}).toMutableMap()
    var cnt = 0
    var i = 0
    var j = 0
    var ans = Pair(1, n)

    while(j < n) {
        if (cnt < k) {
            if(d[a[j]] == 0) {
                cnt += 1
            }
            d[a[j]] = d[a[j]]!! + 1
            j += 1
        } else {
            d[a[i]] = d[a[i]]!! - 1
            if(d[a[i]] == 0) {
                cnt -= 1
                if(j - i < n_tmp) {
                    n_tmp = j - i
                    ans = Pair(i + 1, j)
                }
            }
            i += 1
        }
    }


    while (i < j && cnt == k) {
        d[a[i]] = d[a[i]]!! - 1
        if(d[a[i]] == 0) {
            if(j - i < n_tmp) {
                n_tmp = j - i
                ans = Pair(i + 1, j)
            }
            break
        }
        i += 1
    }

    print("${ans.first} ${ans.second}")
}