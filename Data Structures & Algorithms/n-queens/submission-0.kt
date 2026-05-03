class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        fun isSafe(row: Int, col: Int): Boolean {
            var r = row
            var c = col

            for (i in 0 until col) {
                if (board[row][i] == 'Q') return false
            }

            r = row
            c = col
            while (r >= 0 && c >= 0) {
                if (board[r][c] == 'Q') return false
                r--
                c--
            }

            r = row
            c = col
            while (r < n && c >= 0) {
                if (board[r][c] == 'Q') return false
                r++
                c--
            }

            return true
        }

        fun dfs(col: Int) {
            if (col == n) {
                result.add(board.map { String(it) })
                return
            }

            for (row in 0 until n) {
                if (isSafe(row, col)) {
                    board[row][col] = 'Q'

                    dfs(col + 1)

                    board[row][col] = '.'
                }
            }
        }

        dfs(0)
        return result
    }
}
