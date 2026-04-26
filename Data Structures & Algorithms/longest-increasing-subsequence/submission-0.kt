class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n) { 1 }

        var ans = 1
        for (i in 0 until n) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            ans = maxOf(ans, dp[i])
        }

        return ans
    }
}
