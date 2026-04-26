class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            val a = nums[i]
            if (a > 0) break
            if (i > 0 && a == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val threeSum = a + nums[l] + nums[r]

                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        result.add(listOf(a, nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }

        return result       
    }
}
