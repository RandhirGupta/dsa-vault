class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val stack = ArrayDeque<Int>()
        val result = IntArray(n)

        for (i in 0 until n) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val prevIndex = stack.pop()
                result[prevIndex] = i - prevIndex
            }

            stack.push(i)
        }

        return result
    }
}
