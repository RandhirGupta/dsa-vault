class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        if (n == 0) return 0

        val prefix = IntArray(n)
        val suffix = IntArray(n)

        prefix[0] = height[0]
        for (i in 1 until n) {
            prefix[i] = maxOf(prefix[i - 1], height[i])
        }

        suffix[n - 1] = height[n - 1]
        for (i in n - 2 downTo 0) {
            suffix[i] = maxOf(suffix[i + 1], height[i])
        }

        var water = 0
        for (i in 0 until n) {
            water += minOf(prefix[i], suffix[i]) - height[i]
        }

        return water
    }
}
