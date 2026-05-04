class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix.size
        val n = matrix[0].size

        var firstRowZero = false
        var firstColumnZero = false

        for (i in 0 until m) {
            if (matrix[i][0] == 0) firstColumnZero = true
            
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRowZero = true

                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (firstColumnZero) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }

        if (firstRowZero) {
            for (j in 0 until n) {
                matrix[0][j] = 0
            }
        }
    }
}
