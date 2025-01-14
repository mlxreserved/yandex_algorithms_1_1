package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeNodeB(val value: Int) {
    var left: TreeNodeB? = null
    var right: TreeNodeB? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeB(seq[0])

    val listAnswers = mutableListOf(1)

    for(i in 1 until seq.size - 1) {
        if(!find(root, seq[i])) {
            addToBTS(root, seq[i])
            listAnswers.add(findPos(root, seq[i]))
        }
    }

    print(listAnswers.joinToString(" "))
}

private fun find(root: TreeNodeB, x: Int): Boolean {
    val key = root.value
    return if(key == x) {
        true
    } else if(key < x && root.right != null) {
        find(root.right!!, x)
    } else if(key > x && root.left != null) {
        find(root.left!!, x)
    } else {
        false
    }
}

private fun addToBTS(root: TreeNodeB, x: Int) {
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToBTS(root.left!!, x)
        } else {
            root.left = TreeNodeB(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToBTS(root.right!!, x)
        } else {
            root.right = TreeNodeB(x)
        }
    }
}


private fun findPos(root: TreeNodeB, x: Int): Int {
    val key = root.value
    return if(key > x) {
        1 + findPos(root.left!!, x)
    } else if(key < x) {
        1 + findPos(root.right!!, x)
    } else {
        1
    }
}