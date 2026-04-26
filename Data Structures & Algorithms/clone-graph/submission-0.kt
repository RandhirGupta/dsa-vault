/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {

    private val map = HashMap<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        if (map.containsKey(node)) {
            return map[node]
        }

        val clone = Node(node.`val`)
        map[node] = clone

        for (neighbor in node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor))
        }

        return clone
    }
}
