class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = nums1
        var b = nums2

        if (a.size > b.size) {
            a = nums2
            b = nums1
        }

        val m = a.size
        val n = b.size

        var l = 0
        var r = m

        while (l <= r) {
            val x = l + (r - l) / 2
            val y = (m + n + 1) / 2 - x

            val aLeft = if (x == 0) Int.MIN_VALUE else a[x - 1]
            val aRight = if (x == m) Int.MAX_VALUE else a[x]

            val bLeft = if (y == 0) Int.MIN_VALUE else b[y - 1]
            val bRight = if (y == n) Int.MAX_VALUE else b[y]

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((m + n) % 2 == 1) {
                    return maxOf(aLeft, bLeft).toDouble()
                }

                return (
                    maxOf(aLeft, bLeft) + 
                    minOf(aRight, bRight)
                ) / 2.0
            } else if (aLeft > bRight) {
                r = x - 1
            } else {
                l = x + 1
            }
        }

        return 0.0
    }
}
