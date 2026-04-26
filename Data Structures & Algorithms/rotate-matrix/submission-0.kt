class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        matrix.reverse()
        
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}
