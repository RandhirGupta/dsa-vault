class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        val memo = Array(n) { IntArray(2) { -1 } }
        return dfs(0, 1, prices, memo)
    }

    private fun dfs(
        i: Int,
        canBuy: Int,
        prices: IntArray,
        memo: Array<IntArray>
    ): Int {
        if (i >= prices.size) return 0
        if (memo[i][canBuy] != -1) return memo[i][canBuy]

        val ans = if (canBuy == 1) {
            maxOf(-prices[i] + dfs(i + 1, 0, prices, memo),
            dfs(i + 1, 1, prices, memo)
            )
        } else {
            maxOf(prices[i] + dfs(i + 2, 1, prices, memo),
            maxOf(dfs(i + 1, 0, prices, memo))
            )
        }

        memo[i][canBuy] = ans
        return ans
    }
}
