class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val left = IntArray(n)
        val right = IntArray(n)
        val stack = ArrayDeque<Int>()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop()
            }

            left[i] = if (stack.isEmpty()) -1 else stack.peek()
            stack.push(i)
        }

        stack.clear()

        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop()
            }

            right[i] = if (stack.isEmpty()) n else stack.peek()
            stack.push(i)
        }

        var maxArea = 0
        for (i in 0 until n) {
            val width = right[i] - left[i] - 1
            maxArea = maxOf(maxArea, heights[i] * width)
        }

        return maxArea
    }
}
