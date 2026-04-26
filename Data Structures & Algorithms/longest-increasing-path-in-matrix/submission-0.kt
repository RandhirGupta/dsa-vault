class Solution {
    private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size

        val memo = Array(m) { IntArray(n) }
        var ans = 0

        for (r in 0 until m) {
            for (c in 0 until n) {
                ans = maxOf(ans, dfs(r, c, matrix, memo))
            }
        }

        return ans
    }

    private fun dfs(
        r: Int,
        c: Int,
        matrix: Array<IntArray>,
        memo: Array<IntArray>
    ): Int {
        if (memo[r][c] != 0) return memo[r][c]

        var best = 1
        for ((dr, dc) in dirs) {
            val nr = r + dr
            val nc = c + dc

            if (
                nr in matrix.indices &&
                nc in matrix[0].indices &&
                matrix[nr][nc] > matrix[r][c]
            ) {
                best = maxOf(best, 1 + dfs(nr, nc, matrix, memo))
            }
        }

        memo[r][c] = best
        return best
    }
}
