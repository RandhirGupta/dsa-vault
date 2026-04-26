class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var top = 0
        var bottom = m - 1

        while (top <= bottom) {
            val mid = (top + bottom) / 2

            if (matrix[mid][0] > target) {
                bottom = mid -  1
            } else if (matrix[mid][n - 1] < target) {
                top = mid + 1
            } else {
                return binarySearch(matrix[mid], target)
            }
        }

        return false
    }

    private fun binarySearch(row: IntArray, target: Int): Boolean {
        var left = 0
        var right = row.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                row[mid] == target -> return true
                row[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return false
    }
}
