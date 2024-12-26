import java.io.BufferedReader
import java.io.InputStreamReader

data class TreeNode(
    val name: String,
    var left: TreeNode?,
    var right: TreeNode?,
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var head: TreeNode? = null
    for (i in 0..<n) {
        val (name, left, right) = br.readLine().split(" ")
        val newTree =
            if (left == "." && right == ".") {
                TreeNode(name, null, null)
            } else if (left == ".") {
                TreeNode(name, null, TreeNode(right, null, null))
            } else if (right == ".") {
                TreeNode(name, TreeNode(left, null, null), null)
            } else {
                TreeNode(name, TreeNode(left, null, null), TreeNode(right, null, null))
            }
        if (head == null) {
            head = newTree
        } else {
            val target = preorderSearch(name, head) ?: throw IllegalArgumentException()
            target.left = if (left == ".") {
                null
            } else {
                TreeNode(left, null, null)
            }
            target.right = if (right == ".") {
                null
            } else {
                TreeNode(right, null, null)
            }
        }

    }

    if (head == null)
        throw IllegalArgumentException()
    preOrder(head)
    println()
    inOrder(head)
    println()
    postOrder(head)
}

fun preorderSearch(target: String, tree: TreeNode?): TreeNode? {
    if (tree == null) return null
    if (tree.name == target) return tree

    var answer: TreeNode?
    answer = preorderSearch(target, tree.left)
    if (answer != null) return answer
    answer = preorderSearch(target, tree.right)
    if (answer != null) return answer
    return null
}

fun preOrder(tree: TreeNode?) {
    if (tree == null) return

    print(tree.name)

    preOrder(tree.left)

    preOrder(tree.right)
}

fun inOrder(tree: TreeNode?) {
    if (tree == null) return

    inOrder(tree.left)

    print(tree.name)

    inOrder(tree.right)
}

fun postOrder(tree: TreeNode?) {
    if (tree == null) return

    postOrder(tree.left)

    postOrder(tree.right)

    print(tree.name)
}
