class Solution {
    fun singleNumber(nums: IntArray): Int {
        var xor = 0

        for (num in nums) {
            xor = xor xor num
        }

        return xor
    }
}
