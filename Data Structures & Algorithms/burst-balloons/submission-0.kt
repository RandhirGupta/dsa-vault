class Solution {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size

        val arr = IntArray(n + 2)
        arr[0] = 1
        arr[n + 1] = 1
        for (i in nums.indices) {
            arr[i + 1] = nums[i]
        }

        val memo = Array(n + 2) { IntArray(n + 2) }
        return dfs(1, n, arr, memo)
    }

    private fun dfs(
        l: Int,
        r: Int, 
        nums: IntArray,
        memo: Array<IntArray>
    ): Int {
        if (l > r) return 0
        if (memo[l][r] != 0) return memo[l][r]

        var best = 0
        for (i in l..r) {
            val coins = 
                    nums[l - 1] * nums[i] * nums[r + 1] + 
                    dfs(l, i - 1, nums, memo) + 
                    dfs(i + 1, r, nums, memo)

            best = maxOf(best, coins)
        }

        memo[l][r] = best
        return best
    }
}
