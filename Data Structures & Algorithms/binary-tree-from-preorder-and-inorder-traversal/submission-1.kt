/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private var preIndex = 0
    private val map = HashMap<Int, Int>()

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        for (i in inorder.indices) {
            map[inorder[i]] = i
        }

        return dfs(preorder, 0, inorder.size - 1)
    }

    private fun dfs(preorder: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) return null

        val rootVal = preorder[preIndex++]
        val root = TreeNode(rootVal)

        val mid = map[rootVal]

        if (mid != null) {
            root.left = dfs(preorder, l, mid - 1)
            root.right = dfs(preorder, mid + 1, r)
        }

        return root
    }
}
