class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        var fresh = 0

        for (r in 0 until m) {
            for (c in 0 until n) {
                when (grid[r][c]) {
                    2 -> queue.add(r to c)
                    1 -> fresh++
                }
            }
        }

        if (fresh == 0) return 0

        var minutes = 0

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {
            val size = queue.size
            var rottedThisRound = false

            repeat(size) {
                val (r, c) = queue.removeFirst()

                for ((dr, dc) in dirs) {
                    val nr = r + dr
                    val nc = c + dc

                    if (
                        nr in 0 until m &&
                        nc in 0 until n &&
                        grid[nr][nc] == 1
                    ) {
                        grid[nr][nc] = 2
                        queue.add(nr to nc)
                        fresh--
                        rottedThisRound = true
                    }
                }
            }

            if (rottedThisRound) minutes++
        }

        return if (fresh == 0) minutes else -1
    }
}
