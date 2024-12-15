package lecture4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val listLower = MutableList(26) { 0 }
    val listUpper = MutableList(26) { 0 }

    val (g, s) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toInt() }
    val gString = reader.readLine().trim()
    val sString = reader.readLine().trim()

    for (c in gString) {
        if (c.isUpperCase()) {
            listUpper[c - 'A'] += 1
        } else {
            listLower[c - 'a'] += 1
        }
    }

    val currentLower = MutableList(26) { 0 }
    val currentUpper = MutableList(26) { 0 }

    for (i in 0 until g) {
        val c = sString[i]
        if (c.isUpperCase()) {
            currentUpper[c - 'A'] += 1
        } else {
            currentLower[c - 'a'] += 1
        }
    }

    var count = 0
    if (currentLower == listLower && currentUpper == listUpper) {
        count++
    }

    for (i in g until s) {
        val addChar = sString[i]
        val removeChar = sString[i - g]

        if (removeChar.isUpperCase()) {
            currentUpper[removeChar - 'A'] -= 1
        } else {
            currentLower[removeChar - 'a'] -= 1
        }

        if (addChar.isUpperCase()) {
            currentUpper[addChar - 'A'] += 1
        } else {
            currentLower[addChar - 'a'] += 1
        }

        if (currentLower == listLower && currentUpper == listUpper) {
            count++
        }
    }

    print(count)
}