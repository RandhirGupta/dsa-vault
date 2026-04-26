class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val memo = Array(word1.length) { IntArray(word2.length) { -1 } }
        return dfs(0, 0, word1, word2, memo)
    }

    private fun dfs(
        i: Int,
        j: Int,
        word1: String,
        word2: String,
        memo: Array<IntArray>
    ): Int {
        if (i == word1.length) return word2.length - j
        if (j == word2.length) return word1.length - i
        if (memo[i][j] != -1) return memo[i][j]

        val ans = if (word1[i] == word2[j]) {
            dfs(i + 1, j + 1, word1, word2, memo)
        } else {
            1 + minOf(
                dfs(i, j + 1, word1, word2, memo),
                dfs(i + 1, j, word1, word2, memo),
                dfs(i + 1, j + 1, word1, word2, memo)
            )
        }

        memo[i][j] = ans
        return ans
    }
}
