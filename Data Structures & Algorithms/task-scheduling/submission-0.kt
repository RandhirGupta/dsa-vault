class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        for (t in tasks) {
            freq[t - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (f in freq) {
            if (f > 0) maxHeap.add(f)
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        var time = 0
        
        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            time++

            if (maxHeap.isNotEmpty()) {
                val count = maxHeap.poll() - 1
                if (count > 0) {
                    queue.offer(Pair(count, time + n))
                }
            }

            if (queue.isNotEmpty() && queue.peek().second == time) {
                maxHeap.offer(queue.poll().first)
            }

            if (maxHeap.isEmpty() && queue.isNotEmpty()) {
                time = queue.peek().second - 1
            }
        }

        return time
    }
}
