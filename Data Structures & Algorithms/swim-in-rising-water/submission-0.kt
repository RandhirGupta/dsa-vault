class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        val dist = Array(n) { IntArray(n) { Int.MAX_VALUE }}
        dist[0][0] = grid[0][0]

        val heap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        heap.add(Triple(grid[0][0], 0, 0))

        while (heap.isNotEmpty()) {
            val (time, r, c) = heap.poll()

            if (r == n - 1 && c == n - 1) {
                return time
            }

            for ((dr, dc) in dirs) {
                val nr = dr + r
                val nc = dc + c

                if (
                    nr in 0 until n &&
                    nc in 0 until n
                ) {
                    val newTime = maxOf(time, grid[nr][nc])

                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime
                        heap.add(Triple(newTime, nr, nc))
                    }
                }
            }
        }

        return -1
    }
}
