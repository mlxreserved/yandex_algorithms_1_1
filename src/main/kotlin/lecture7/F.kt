package lecture7

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

const val CHECK = 1
const val DEATH = -1

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()

    val events = mutableListOf<Triple<Int, Int, Int>>()


    repeat(n) { pos ->
        val dates = reader.readLine().trim().split(" ").map { it.toInt() }
        val dayBirth = dates[0]
        val monthBirth = dates[1]
        val yearBirth = dates[2]
        val dayDeath = dates[3]
        val monthDeath = dates[4]
        val yearDeath = dates[5]
        val daysTo18 = dateToDay(dayBirth, monthBirth, yearBirth + 18)
        val daysToDeath = dateToDay(dayDeath, monthDeath, yearDeath)

        if(daysTo18 < daysToDeath) {
            val daysTo80 = dateToDay(dayBirth, monthBirth, yearBirth + 80)
            events.add(Triple(daysTo18, CHECK, pos + 1))
            events.add(Triple(min(daysTo80, daysToDeath), DEATH, pos + 1))
        }

    }

    events.sortWith(compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second })

    val together = mutableSetOf<Int>()
    var updated = false

    if (events.size == 0) {
        print(0)
    } else {
        for (i in events) {
            if (i.second == CHECK) {
                together.add(i.third)
                updated = true
            } else {
                if(updated) {
                    print(together.joinToString(separator = " ", postfix = "\n"))
                    updated = false
                }
                together.remove(i.third)
            }
        }
    }
}


fun dateToDay(day: Int, month: Int, year: Int): Int {
    var daysFromDate = 0

    for (i in 1 until year) {
        if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { // Високосный
            daysFromDate += 366
        } else { // Обычный
            daysFromDate += 365
        }
    }

    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        when (month) {
            1 -> daysFromDate += 31 - (31 - day + 1)
            2 -> daysFromDate += 60 - (29 - day + 1)
            3 -> daysFromDate += 91 - (31 - day + 1)
            4 -> daysFromDate += 121 - (30 - day + 1)
            5 -> daysFromDate += 152 - (31 - day + 1)
            6 -> daysFromDate += 182 - (30 - day + 1)
            7 -> daysFromDate += 213 - (31 - day + 1)
            8 -> daysFromDate += 244 - (31 - day + 1)
            9 -> daysFromDate += 274 - (30 - day + 1)
            10 -> daysFromDate += 305 - (31 - day + 1)
            11 -> daysFromDate += 335 - (30 - day + 1)
            12 -> daysFromDate += 366 - (31 - day + 1)
        }
    } else {
        when (month) {
            1 -> daysFromDate += 31 - (31 - day + 1)
            2 -> daysFromDate += 59 - (28 - day + 1)
            3 -> daysFromDate += 90 - (31 - day + 1)
            4 -> daysFromDate += 120 - (30 - day + 1)
            5 -> daysFromDate += 151 - (31 - day + 1)
            6 -> daysFromDate += 181 - (30 - day + 1)
            7 -> daysFromDate += 212 - (31 - day + 1)
            8 -> daysFromDate += 243 - (31 - day + 1)
            9 -> daysFromDate += 273 - (30 - day + 1)
            10 -> daysFromDate += 304 - (31 - day + 1)
            11 -> daysFromDate += 334 - (30 - day + 1)
            12 -> daysFromDate += 365 - (31 - day + 1)
        }
    }


    return daysFromDate
}