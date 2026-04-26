class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        for ((a, b) in prerequisites) {
            graph[a].add(b)
        }

        val state = IntArray(numCourses)
        for (course in 0 until numCourses) {
            if (!dfs(course, graph, state)) return false
        }

        return true
    }

    private fun dfs(
        node: Int,
        graph: Array<MutableList<Int>>,
        state: IntArray
    ): Boolean {
        if (state[node] == 1) return false
        if (state[node] == 2) return true

        state[node] = 1
        for(neighbor in graph[node]) {
            if (!dfs(neighbor, graph, state)) return false
        }

        state[node] = 2
        return true
    }
}
