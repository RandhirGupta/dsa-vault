/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return maxSum
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftGain = maxOf(0, dfs(node.left))
        val rightGain = maxOf(0, dfs(node.right))

        val currentPath = node.`val` + leftGain + rightGain

        maxSum = maxOf(maxSum, currentPath)

        return node.`val` + maxOf(leftGain, rightGain)
    }
}
