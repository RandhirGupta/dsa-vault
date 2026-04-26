/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private var count = 0

    fun goodNodes(root: TreeNode?): Int {
        dfs(root, Int.MIN_VALUE)
        return count
    }

    private fun dfs(node: TreeNode?, maxSoFar: Int) {
        if (node == null) return

        if (node.`val` >= maxSoFar) {
            count++
        }

        val newMax = maxOf(maxSoFar, node.`val`)

        dfs(node.left, newMax)
        dfs(node.right, newMax)
    }
}
