package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeC(val value: Int) {
    var left: TreeNodeC? = null
    var right: TreeNodeC? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeC(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }

    print(findMax(root, root.value, null))

}


private fun addToBTS(root: TreeNodeC, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeC(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeC(x)
        }
    }
}


private fun findMax(root: TreeNodeC, curVal: Int, from: Boolean?): Int {
    if(root.right != null) {
        if(from == null) {
            return findMax(root.right!!, root.value, true)
        } else {
            return findMax(root.right!!, root.value, from)
        }
    } else if(root.left != null && from != false) {
        return findMax(root.left!!, root.value, false)

    }
    return if(root.value < curVal || from == false) root.value else curVal
}