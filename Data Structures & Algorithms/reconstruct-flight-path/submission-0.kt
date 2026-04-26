class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val graph = HashMap<String, PriorityQueue<String>>()

        for (ticket in tickets) {
            val from = ticket[0]
            val to = ticket[1]

            graph
                .computeIfAbsent(from) { PriorityQueue() }
                .add(to)
        }

        val result = LinkedList<String>()

        fun dfs(airport: String) {
            val neighbors = graph[airport]

            while(neighbors != null && neighbors.isNotEmpty()) {
                val next = neighbors.poll()
                dfs(next)
            }

            result.addFirst(airport)
        }

        dfs("JFK")

        return result
    }
}
