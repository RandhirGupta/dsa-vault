class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = Array(coins.size) { IntArray(amount + 1) { -1 } }
        return dfs(0, amount, coins, memo)
    }

    private fun dfs(
        i: Int,
        remaining: Int,
        coins: IntArray,
        memo: Array<IntArray>
    ): Int {
        if (remaining == 0) return 1
        if (remaining < 1) return 0
        if (i == coins.size) return 0

        if (memo[i][remaining] != -1) return memo[i][remaining]
        val take = dfs(i, remaining - coins[i], coins, memo)
        val skip = dfs(i + 1, remaining, coins, memo)

        memo[i][remaining] = take + skip
        return memo[i][remaining]
    }
}
