class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxHeap = PriorityQueue<IntArray> { a, b -> 
            b[0] - a[0]
        }

        val result = IntArray(nums.size - k + 1)

        var left = 0
        var idx = 0

        for (right in nums.indices) {
            maxHeap.offer(intArrayOf(nums[right], right))

            if (right - left + 1 == k) {
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll()
                }

                result[idx++] = maxHeap.peek()[0]
                left++
            }
        }

        return result
    }
}
