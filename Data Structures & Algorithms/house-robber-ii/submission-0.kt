class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]

        val memo = Array(n) { IntArray(2) { -1 } }

        fun robLinear(start: Int, end: Int): Int {
            var prev1 = 0
            var prev2 = 0

            for (i in start..end) {
                val current = maxOf(prev1, prev2 + nums[i])
                prev2 = prev1
                prev1 = current
            }

            return prev1
        }

        return maxOf(robLinear(0, n - 2), robLinear(1, n - 1))
    }
}
