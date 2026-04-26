class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for (i in nums.indices) {
            val num = Math.abs(nums[i])

            if (nums[num] < 0) {
                return num
            }

            nums[num] = -nums[num]
        }
        
        return -1
    }
}
