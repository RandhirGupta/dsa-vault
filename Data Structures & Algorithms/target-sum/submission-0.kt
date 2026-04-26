class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val total = nums.sum()
        val memo = Array(nums.size) { IntArray(2 * total + 1) { Int.MIN_VALUE } }
        return dfs(0, 0, nums, target, total, memo)
    }

    private fun dfs(
        i: Int,
        sum: Int,
        nums: IntArray,
        target: Int,
        offset: Int,
        memo: Array<IntArray>
    ): Int {
        if (i == nums.size) {
            return if (sum == target) 1 else 0
        }

        val key = sum + offset
        if (memo[i][key] != Int.MIN_VALUE) return memo[i][key]

        val add = dfs(i + 1, sum + nums[i], nums, target, offset, memo)
        val substract = dfs(i + 1, sum - nums[i], nums, target, offset, memo)
        memo[i][key] = add + substract
        return memo[i][key]
    }
}
