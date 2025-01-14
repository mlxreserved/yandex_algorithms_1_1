package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

class TreeNodeH(val value: Int) {
    var left: TreeNodeH? = null
    var right: TreeNodeH? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeH(seq[0])

    for(i in 1 until seq.size - 1) {
        addToBTS(root, seq[i])
    }

    if(isBalanced(root)) {
        print("YES")
    } else {
        print("NO")
    }
}

private fun addToBTS(root: TreeNodeH, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeH(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeH(x)
        }
    }
}

private fun isBalanced(root: TreeNodeH): Boolean {
    val lHeight = if(root.left != null) {
        findHeight(root.left!!)
    } else {
        0
    }
    val rHeight = if(root.right != null) {
        findHeight(root.right!!)
    } else {
        0
    }
    if (abs(lHeight - rHeight) <= 1) {
        val lBalanced = if(root.left != null)
            isBalanced(root.left!!)
        else {
            true
        }
        val rBalanced = if(root.right != null)
            isBalanced(root.right!!)
        else {
            true
        }
        return rBalanced && lBalanced
    } else {
        return false
    }
}

private fun findHeight(root: TreeNodeH?): Int {
    if (root?.left == null && root?.right == null) {
        return 1
    }
    else {
        return 1 + max(findHeight(root.left), findHeight(root.right))
    }
}