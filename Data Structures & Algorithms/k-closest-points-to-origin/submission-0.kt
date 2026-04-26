class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray> { a, b ->
            distance(b) - distance(a)
        }

        for (point in points) {
            maxHeap.offer(point)

            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        return maxHeap.toTypedArray()
    }

    private fun distance(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1]
    }
}
