class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()

        if (sum % 2 != 0) return false

        val target = sum / 2
        val memo = Array(nums.size) { BooleanArray(target + 1) { false } }
        val visited = Array(nums.size) { BooleanArray(target + 1) { false } }

        return dfs(0, 0, nums, target, memo, visited)
    }

    private fun dfs(
        i: Int,
        currSum: Int,
        nums: IntArray,
        target: Int,
        memo: Array<BooleanArray>,
        visited: Array<BooleanArray>,
    ): Boolean {
        if (currSum == target) return true
        if (i == nums.size) return false

        if (visited[i][currSum]) return memo[i][currSum]

        var take = false
        if (currSum + nums[i] <= target) {
            take = dfs(i + 1, currSum + nums[i], nums, target, memo, visited)
        }

        val skip = dfs(i + 1, currSum, nums, target, memo, visited)
        visited[i][currSum] = true
        memo[i][currSum] = take || skip
        return memo[i][currSum]
    }
}
