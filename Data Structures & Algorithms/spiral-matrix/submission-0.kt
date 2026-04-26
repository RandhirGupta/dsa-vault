class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()

        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            for (col in left..right) {
                result.add(matrix[top][col])
            }
            top++

            for (row in top..bottom) {
                result.add(matrix[row][right])
            }
            right--

            if (top <= bottom) {
                for (col in right downTo left) {
                    result.add(matrix[bottom][col])
                }
            }
            bottom--

            if (left <= right) {
                for (row in bottom downTo top) {
                    result.add(matrix[row][left])
                }
            }
            left++
        }

        return result
    }
}
