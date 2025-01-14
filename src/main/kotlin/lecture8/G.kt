package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeG(val value: Int) {
    var left: TreeNodeG? = null
    var right: TreeNodeG? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeG(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }

    findBranch(root)
}

private fun addToBTS(root: TreeNodeG, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeG(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeG(x)
        }
    }
}

private fun findBranch(root: TreeNodeG) {
    if(root.left != null) {
        findBranch(root.left!!)
    }
    if(root.left != null && root.right == null || root.left == null && root.right != null) {
        println(root.value)
    }
    if(root.right != null) {
        findBranch(root.right!!)
    }
}