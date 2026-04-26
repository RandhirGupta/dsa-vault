class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parent = IntArray(n + 1) { it }
        val rank = IntArray(n + 1)

        for (edge in edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                return edge
            }
        }

        return intArrayOf()
    }

    private fun find(x: Int, parent: IntArray): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent)
        }

        return parent[x]
    }

    private fun union(a: Int, b: Int, parent: IntArray, rank: IntArray): Boolean {
        val rootA = find(a, parent)
        val rootB = find(b, parent)

        if (rootA == rootB) return false

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA
        } else {
            parent[rootB] = rootA
            rank[rootA]++
        }

        return true
    }
}
