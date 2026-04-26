class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        val edges = mutableListOf<Triple<Int, Int, Int>>()

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val dist = 
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1])
                edges.add(Triple(dist, i, j))
            }
        }

        edges.sortBy { it.first }

        val parent = IntArray(n) { it }
        val rank = IntArray(n)

        var cost = 0
        var edgesUsed = 0

        for ((weight, u, v) in edges) {
            if (union(u, v, parent, rank)) {
                cost += weight
                edgesUsed++

                if (edgesUsed == n - 1) {
                    break
                }
            }
        }

        return cost
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
