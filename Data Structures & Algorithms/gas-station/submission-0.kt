class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var totalCost = 0
        var current = 0
        var start = 0

        for (i in gas.indices) {
            val diff = gas[i] - cost[i]

            totalGas += gas[i]
            totalCost += cost[i]
            current += diff

            if (current < 0) {
                start = i + 1
                current = 0
            }
        }

        return if (totalGas >= totalCost) start else -1
    }
}
