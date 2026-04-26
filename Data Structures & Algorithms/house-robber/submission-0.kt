class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val memo = IntArray(n + 1) { -1 }

        fun dfs(i: Int): Int {
            if (i >= n) return 0
            if (memo[i] != -1) return memo[i]

            memo[i] = maxOf(dfs(i + 1), nums[i] + dfs(i + 2))
            return memo[i]
        }

        return dfs(0)
    }
}
