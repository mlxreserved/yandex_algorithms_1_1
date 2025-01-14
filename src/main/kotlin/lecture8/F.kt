package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeF (val value: Int) {
    var left: TreeNodeF? = null
    var right: TreeNodeF? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeF(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }

    findRoots(root)
}

private fun addToBTS(root: TreeNodeF, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeF(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeF(x)
        }
    }
}

private fun findRoots(root: TreeNodeF) {
    if(root.left != null) {
        findRoots(root.left!!)
    }
    if(root.left != null && root.right != null) {
        println(root.value)
    }
    if(root.right != null) {
        findRoots(root.right!!)
    }
}