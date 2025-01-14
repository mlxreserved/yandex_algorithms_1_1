package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeD(val value: Int) {
    var left: TreeNodeD? = null
    var right: TreeNodeD? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeD(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }
    printBTS(root)
}

private fun addToBTS(root: TreeNodeD, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeD(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeD(x)
        }
    }
}

private fun printBTS(root: TreeNodeD) {
    if(root.left == null && root.right == null) {
        println(root.value)
    }
    if(root.left != null) {
        printBTS(root.left!!)
        println(root.value)
    }
    if(root.right != null && root.left == null) {
        println(root.value)
        printBTS(root.right!!)
    } else if(root.right != null){
        printBTS(root.right!!)
    }

}