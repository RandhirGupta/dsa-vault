class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m) { IntArray(n) { -1 } }
        return dfs(0, 0, m, n, memo)
    }

    private fun dfs(
        i: Int,
        j: Int,
        m: Int,
        n: Int,
        memo: Array<IntArray>
    ): Int {
        if (i >= m || j >= n) return 0
        if (i == m - 1 && j == n - 1) return 1
        if (memo[i][j] != -1) return memo[i][j]

        val path = dfs(i + 1, j, m, n, memo) + dfs(i, j + 1, m, n, memo)
        memo[i][j] = path
        return path
    }
}
