class Solution {
    fun numDecodings(s: String): Int {
        val memo = IntArray(s.length) { -1 }
        return dfs(0, s, memo)
    }

    private fun dfs(i: Int, s: String, memo: IntArray): Int {
        if (i == s.length) return 1
        if (s[i] == '0') return 0
        if (memo[i] != -1) return memo[i]

        var ways = dfs(i + 1, s, memo)
        if (i + 1 < s.length) {
            val num = (s[i] - '0') * 10 + (s[i + 1] - '0')
            if (num in 10..26) {
                ways += dfs(i + 2, s, memo)
            }
        }

        memo[i] = ways
        return ways
    }
}
