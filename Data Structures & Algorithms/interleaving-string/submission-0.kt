class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false

        val memo = Array(s1.length + 1) { Array<Boolean?>(s2.length + 1) { null } }
        return dfs(0, 0, s1, s2, s3, memo)
    }

    private fun dfs(
        i: Int,
        j: Int,
        s1: String,
        s2: String,
        s3: String,
        memo: Array<Array<Boolean?>>
    ): Boolean {
        if (i == s1.length && j == s2.length) return true
        if (memo[i][j] != null) return memo[i][j]!!

        val k = i + j
        var ans = false
        if (i < s1.length && s1[i] == s3[k]) {
            ans = dfs(i + 1, j, s1, s2, s3, memo)
        }

        if (j < s2.length && s2[j] == s3[k]) {
            ans = dfs(i, j + 1, s1, s2, s3, memo)
        }

        memo[i][j] = ans
        return ans
    }
}
