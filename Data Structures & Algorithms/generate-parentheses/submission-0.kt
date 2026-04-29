class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun dfs(current: String, open: Int, close: Int) {
            if (current.length == 2 * n) {
                result.add(current)
                return
            }

            if (open < n) {
                dfs(current + "(", open + 1, close)
            }

            if (close < open) {
                dfs(current + ")", open, close + 1)
            }
        }

        dfs("", 0, 0)
        return result
    }
}
