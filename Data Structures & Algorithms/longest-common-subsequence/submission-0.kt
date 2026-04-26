class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val memo = Array(m) { IntArray(n) { -1 } }

        return dfs(0, 0, text1, text2, memo)
    }

    private fun dfs(i: Int, j: Int, text1: String, text2: String, memo: Array<IntArray>): Int {
        if (i == text1.length || j == text2.length) return 0
        if (memo[i][j] != -1) return memo[i][j]

        val ans = if (text1[i] == text2[j]) {
            1 + dfs(i + 1, j + 1, text1, text2, memo)
        } else {
            maxOf(
                dfs(i + 1, j, text1, text2, memo),
                dfs(i, j + 1, text1, text2, memo)
            )
        }

        memo[i][j] = ans
        return ans
    }
}
