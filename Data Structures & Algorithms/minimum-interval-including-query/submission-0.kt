class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it[0] }

        val sortedQueries = queries
                    .mapIndexed { index, value -> intArrayOf(value, index) }
                    .sortedBy { it[0] }
        
        val result = IntArray(queries.size) { -1 }

        val minHeap = PriorityQueue<IntArray> { a, b -> 
            a[0] - b[0]
        }

        var i = 0

        for (queryPair in sortedQueries) {
            val query = queryPair[0]
            val index = queryPair[1]

            while (i < intervals.size && intervals[i][0] <= query) {
                val start = intervals[i][0]
                val end = intervals[i][1]
                val size = end - start + 1
                minHeap.offer(intArrayOf(size, end))
                i++
            }

            while (minHeap.isNotEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll()
            }

            if (minHeap.isNotEmpty()) {
                result[index] = minHeap.peek()[0]
            }
        }

        return result
    }
}
