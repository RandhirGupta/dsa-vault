class Solution {

    private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size

        val pacific = Array(m) { BooleanArray(n) }
        val atlantic = Array(m) { BooleanArray(n) }
        
        for (c in 0 until n) {
            dfs(m, n, 0, c, heights, pacific)
        }

        for (r in 0 until m) {
            dfs(m, n, r, 0, heights, pacific)
        }

        for (c in 0 until n) {
            dfs(m, n, m - 1, c, heights, atlantic)
        }

        for (r in 0 until m) {
            dfs(m, n, r, n - 1, heights, atlantic)
        }

        val result = mutableListOf<List<Int>>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }

    private fun dfs(m: Int, n: Int, r: Int, c: Int, heights: Array<IntArray>, visited: Array<BooleanArray>) {
        visited[r][c] = true

        for ((dr, dc) in dirs) {
            val nr = r + dr
            val nc = c + dc

            if (nr in 0 until m &&
                nc in 0 until n &&
                !visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]
            ) {
                dfs(m, n, nr, nc, heights, visited)
            }
        }
    }
}
