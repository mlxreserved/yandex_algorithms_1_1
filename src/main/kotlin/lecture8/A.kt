package lecture8

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

class TreeNodeA(val value: Int) {
    var left: TreeNodeA? = null
    var right: TreeNodeA? = null
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val seq = reader.readLine().trim().split(" ").map { it.toInt() }

    val root = TreeNodeA(seq[0])

    for(i in 1 until seq.size - 1){
        addToTree(root, seq[i])
    }



    print(findHeight(root))
}

private fun addToTree(root: TreeNodeA, x: Int){
    val key = root.value
    if(key > x) {
        if(root.left != null) {
            addToTree(root.left!!, x)
        } else {
            root.left = TreeNodeA(x)
        }
    } else if(key < x) {
        if(root.right != null) {
            addToTree(root.right!!, x)
        } else {
            root.right = TreeNodeA(x)
        }
    }
}


private fun findHeight(root: TreeNodeA?): Int {
    if (root?.left == null && root?.right == null) {
        return 1
    }
    else {
        return 1 + max(findHeight(root.left), findHeight(root.right))
    }
}