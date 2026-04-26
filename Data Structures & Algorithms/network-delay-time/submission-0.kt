class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = HashMap<Int, MutableList<Pair<Int, Int>>>()

        for ((u, v, w) in times) {
            graph
                .computeIfAbsent(u) { mutableListOf() }
                .add(v to w)
        }

        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        dist[k] = 0

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        heap.add(0 to k)

        while (heap.isNotEmpty()) {
            val (currentDist, node) = heap.poll()

            if (currentDist > dist[node]) {
                continue
            }

            val neighbors = graph[node] ?: continue

            for ((neighbor, weight) in neighbors) {
                val newDist = currentDist + weight

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist
                    heap.add(newDist to neighbor)
                }
            }
        }

        var maxTime = 0

        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE) {
                return -1
            }

            maxTime = maxOf(maxTime, dist[i])
        }

        return maxTime
    }
}
