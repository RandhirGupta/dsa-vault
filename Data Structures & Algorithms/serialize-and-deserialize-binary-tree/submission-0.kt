/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        dfsSerialize(root, sb)
        return sb.toString()
    }

    private fun dfsSerialize(node: TreeNode?, sb: StringBuilder) {
        if (node == null) {
            sb.append("N,")
            return
        }
        
        sb.append(node.`val`).append(",")

        dfsSerialize(node.left, sb)
        dfsSerialize(node.right, sb)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val nodes = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            if (nodes[i] == "N") {
                i++
                return null
            }

            val node = TreeNode(nodes[i++].toInt())
            node.left = dfs()
            node.right = dfs()

            return node
        }

        return dfs()
    }
}
