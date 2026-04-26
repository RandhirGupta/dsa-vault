class Solution {

    private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun solve(board: Array<CharArray>) {
        val m = board.size
        val n = board[0].size

        for (c in 0 until n) {
            dfs(m, n, 0, c, board)
            dfs(m, n, m - 1, c, board)
        }

        for (r in 0 until m) {
            dfs(m, n, r, 0, board)
            dfs(m, n, r, n - 1, board)
        }

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'
                }

                if (board[r][c] == '#') {
                    board[r][c] = 'O'
                }
            }            
        }
    }

    private fun dfs(
        m: Int,
        n: Int,
        r: Int,
        c: Int,
        board: Array<CharArray>
    ) {
        if (
            r !in 0 until m ||
            c !in 0 until n ||
            board[r][c] != 'O'
        ) return

        board[r][c] = '#'

        for ((dr, dc) in dirs) {
            dfs(m, n, r + dr, c + dc, board)
        }
    }
}
