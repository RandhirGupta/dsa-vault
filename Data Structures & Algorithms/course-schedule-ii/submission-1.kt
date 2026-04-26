class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        for ((a, b) in prerequisites) {
            graph[b].add(a)
        }

        val state = IntArray(numCourses)
        val order = mutableListOf<Int>()

        for (i in 0 until numCourses) {
            if (!dfs(i, graph, state, order)) return intArrayOf()
        }

        order.reverse()
        return order.toIntArray()
    }

    private fun dfs(
        node: Int,
        graph: Array<MutableList<Int>>,
        state: IntArray,
        order: MutableList<Int>
    ): Boolean {
        if (state[node] == 1) return false
        if (state[node] == 2) return true
        
        state[node] = 1
        for (neighbor in graph[node]) {
            if (!dfs(neighbor, graph, state, order)) return false
        }

        state[node] = 2
        order.add(node)
        return true
    }
}
