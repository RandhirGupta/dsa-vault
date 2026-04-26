class Solution {
    fun numDistinct(s: String, t: String): Int {
        val memo = Array(s.length) { IntArray(t.length) { -1 } }
        return dfs(0, 0, s, t, memo)
    }

    private fun dfs(
        i: Int,
        j: Int,
        s: String,
        t: String,
        memo: Array<IntArray>
    ): Int {
        if (j == t.length) return 1
        if (i == s.length) return 0
        if (memo[i][j] != -1) return memo[i][j]

        var ans = dfs(i + 1, j, s, t, memo)

        if (s[i] == t[j]) {
            ans += dfs(i + 1, j + 1, s, t, memo)
        }

        memo[i][j] = ans
        return ans
    }
}
