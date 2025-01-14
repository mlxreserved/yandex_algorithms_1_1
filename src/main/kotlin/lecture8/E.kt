package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeE (val value: Int){

    var left: TreeNodeE? = null
    var right: TreeNodeE? = null

}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeE(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }
    printLief(root)
}

private fun addToBTS(root: TreeNodeE, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeE(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeE(x)
        }
    }
}

private fun printLief(root: TreeNodeE) {
    if(root.left == null && root.right == null) {
        println(root.value)
    }
    if(root.left != null) {
        printLief(root.left!!)
    }
    if(root.right != null) {
        printLief(root.right!!)
    }
}