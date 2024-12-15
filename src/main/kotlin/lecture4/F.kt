package lecture4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

fun main() {

    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))
    val map = mutableMapOf<String, MutableMap<String, Long>>()

    input.useLines { lines ->
        lines.forEach { line ->
            val (name, tovar, countS) = line.split(" ")
            val count = countS.toLong()

            map.getOrPut(name) { mutableMapOf() }
                .merge(tovar, count, Long::plus)
        }
    }

    output.use { writer ->
        map.toSortedMap().forEach { (client, products) ->
            writer.write("$client:\n")
            products.toSortedMap().forEach { (product, count) ->
                writer.write("$product $count\n")
            }
        }
    }
}