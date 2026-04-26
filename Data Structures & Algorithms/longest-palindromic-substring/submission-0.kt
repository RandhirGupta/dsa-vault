class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n) { _ -> BooleanArray(n) }
        val ans: IntArray = IntArray(2) { _ -> 0}

        for (i in 0 until n) {
            dp[i][i] = true
        }

        for (i in 0 until n - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                ans[0] = i
                ans[1] = i + 1
            }
        }

        for (diff in 2 until n) {
            for (i in 0 until n - diff) {
                val j = i + diff
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true
                    ans[0] = i
                    ans[1] = j
                }
            }
        }

        return s.substring(ans[0], ans[1] + 1)
    }
}
