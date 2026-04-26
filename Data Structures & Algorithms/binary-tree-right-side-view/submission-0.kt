/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()

                if (i == levelSize - 1) {
                    result.add(node.`val`)
                }

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }

        return result
    }
}
