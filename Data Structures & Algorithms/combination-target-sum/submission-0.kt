class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun dfs(start: Int, remaining: Int) {
            if (remaining == 0) {
                result.add(ArrayList(current))
                return
            }

            if (remaining < 0) return

            for (i in start until nums.size) {
                current.add(nums[i])

                dfs(i, remaining - nums[i])

                current.removeAt(current.size - 1)
            }
        }

        dfs(0, target)
        return result
    }
}
