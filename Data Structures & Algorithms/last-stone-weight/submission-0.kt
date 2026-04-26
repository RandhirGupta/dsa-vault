class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        for (stone in stones) {
            maxHeap.offer(stone)
        }

        while(maxHeap.size > 1) {
            val first = maxHeap.poll()
            val second = maxHeap.poll()

            if (first != second) {
                maxHeap.offer(first - second)
            }
        }

        return if (maxHeap.isEmpty()) 0 else maxHeap.peek()
    }
}
