class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val memo = Array(s.length + 1) { Array<Boolean?>(p.length + 1) { null } }
        return dfs(0, 0, s, p, memo)
    }

    private fun dfs(
        i: Int,
        j: Int,
        s: String,
        p: String,
        memo: Array<Array<Boolean?>>
    ): Boolean {
        if (memo[i][j] != null) return memo[i][j]!!
        if (j == p.length) return i == s.length
        var ans = false
        
        val firstMatch = i < s.length && (s[i] == p[j] || p[j] == '.')
        ans = if (j + 1 < p.length && p[j + 1] == '*') {
            dfs(i, j + 2, s, p, memo) ||
            (firstMatch && dfs(i + 1, j, s, p, memo))
        } else {
            firstMatch && dfs(i + 1, j + 1, s, p, memo)
        }

        memo[i][j] = ans
        return ans
    }
}
