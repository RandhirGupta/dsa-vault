class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { -2 }
        val ans = dfs(amount, coins, memo)
        return if (ans == Int.MAX_VALUE) -1 else ans
    }

    private fun dfs(amount: Int, coins: IntArray, memo: IntArray): Int {
        if (amount == 0) return 0
        if (amount < 0) return Int.MAX_VALUE
        if (memo[amount] != -2) return memo[amount]

        var minCoins = Int.MAX_VALUE
        for (coin in coins) {
            val res = dfs(amount - coin, coins, memo)
            if (res != Int.MAX_VALUE) {
                minCoins = minOf(minCoins, 1 + res)
            }
        }

        memo[amount] = minCoins
        return minCoins
    }
}
