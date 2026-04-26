class Solution {
    fun maxProduct(nums: IntArray): Int {
        var currMax = nums[0]
        var currMin = nums[0]
        var globalMax = nums[0]

        for (i in 1 until nums.size) {
            val x = nums[i]

            val tempMax = maxOf(x, x * currMax, x * currMin)
            val tempMin = minOf(x, x * currMax, x * currMin)

            currMax = tempMax
            currMin = tempMin

            globalMax = maxOf(globalMax, currMax)
        }

        return globalMax
    }
}
