class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false

        val graph = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        val visited = BooleanArray(n)
        if (!dfs(0, -1, visited, graph)) return false

        return visited.all { it }
    }

    private fun dfs(node: Int, parent: Int, visited: BooleanArray, graph: Array<MutableList<Int>>): Boolean {
        if (visited[node]) return false

        visited[node] = true
        for (neighbor in graph[node]) {
            if (neighbor == parent) continue
            if (!dfs(neighbor, node, visited, graph)) return false
        }

        return true
    }
}
