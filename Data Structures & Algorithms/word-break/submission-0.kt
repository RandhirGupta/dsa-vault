class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = Array<Boolean?>(s.length) { null }
        return dfs(0, s, wordDict.toSet(), memo)
    }

    private fun dfs(i: Int, s: String, wordDict: Set<String>, memo: Array<Boolean?>): Boolean {
        if (i == s.length) return true
        if (memo[i] != null) return memo[i]!!

        for (word in wordDict) {
            if (i + word.length <= s.length && 
            s.startsWith(word, i) && 
            dfs(i + word.length, s, wordDict, memo)) {
                memo[i] = true
                return true
            }
        }

        memo[i] = false
        return false
    }
}
