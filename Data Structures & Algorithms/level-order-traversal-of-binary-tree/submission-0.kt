/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level = mutableListOf<Int>()

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                level.add(node.`val`)

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            result.add(level)
        }

        return result
    }
}
