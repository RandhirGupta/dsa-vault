class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = l + (r - l) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] <= nums[r]) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
        }

        return -1
    }
}
