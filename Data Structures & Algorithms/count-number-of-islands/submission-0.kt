class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var count = 0

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == '1') {
                    count++
                    dfs(r, c, grid)
                }
            }
        }

        return count
    }

    private fun dfs(
        r: Int,
        c: Int,
        grid: Array<CharArray>
    ) {
        if (
            r !in grid.indices ||
            c !in grid[0].indices ||
            grid[r][c] == '0'
        ) return

        grid[r][c] = '0'

        dfs(r + 1, c, grid)
        dfs(r, c + 1, grid)
        dfs(r - 1, c, grid)
        dfs(r, c - 1, grid)
    }
}
