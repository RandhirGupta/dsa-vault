class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var maxArea = 0

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 1) {
                    val area = dfs(r, c, grid)
                    maxArea = maxOf(maxArea, area)
                }
            }
        }

        return maxArea
    }

    private fun dfs(
        r: Int,
        c: Int,
        grid: Array<IntArray>
    ): Int {
        if (
            r !in grid.indices ||
            c !in grid[0].indices ||
            grid[r][c] == 0
        ) return 0

        grid[r][c] = 0

        return 1 + 
                dfs(r + 1, c, grid) +
                dfs(r - 1, c, grid) +
                dfs(r, c + 1, grid) +
                dfs(r, c - 1, grid)

    }
}
