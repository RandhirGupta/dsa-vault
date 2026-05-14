class Solution {
    fun missingNumber(nums: IntArray): Int {
        var xor = nums.size

        for (i in nums.indices) {
            xor = xor xor i xor nums[i]
        }

        return xor
    }
}
