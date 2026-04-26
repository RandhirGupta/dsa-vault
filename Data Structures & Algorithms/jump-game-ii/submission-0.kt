class Solution {
    fun jump(nums: IntArray): Int {
        var left = 0
        var right = 0
        var jumps = 0

        while (right < nums.size - 1) {
            var farthest = 0

            for (i in left..right) {
                farthest = maxOf(farthest, i + nums[i])
            }

            left = right + 1
            right = farthest
            jumps++
        }

        return jumps
    }
}
