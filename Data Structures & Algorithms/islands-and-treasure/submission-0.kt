class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val m = grid.size
        val n = grid[0].size

        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 0) {
                    queue.add(r to c)
                }
            }
        }

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()

            for ((dr, dc) in dirs) {
                val nr = r + dr
                val nc = c + dc

                if (
                    nr in 0 until m &&
                    nc in 0 until n &&
                    grid[nr][nc] == Int.MAX_VALUE
                ) {
                    grid[nr][nc] = grid[r][c] + 1
                    queue.add(nr to nc)
                }
            }
        }
    }
}
