class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val memo = IntArray(cost.size) { -1 }

        fun dfs(i: Int): Int {
            if (i >= cost.size) {
                return 0
            }

            if(memo[i] != -1) return memo[i]

            memo[i] = cost[i] + minOf(dfs(i + 1), dfs(i + 2))
            return memo[i]
        }

        return minOf(dfs(0), dfs(1))
    }
}
