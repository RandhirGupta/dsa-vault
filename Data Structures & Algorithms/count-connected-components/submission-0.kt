class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = DSU(n)
        var components = n

        for ((u, v) in edges) {
            if (dsu.union(u, v)) {
                components--
            }
        }

        return components
    }
}

class DSU(n: Int) {
    private val parent = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }

        return parent[x]
    }

    fun union(a: Int, b: Int): Boolean {
        var rootA = find(a)
        var rootB = find(b)

        if (rootA == rootB) return false

        if (size[rootA] < size[rootB]) {
            val temp = rootA
            rootA = rootB
            rootB = temp
        }

        parent[rootB] = rootA
        size[rootA] += size[rootB]
        
        return true
    }
}
