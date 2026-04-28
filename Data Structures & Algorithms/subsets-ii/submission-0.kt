class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val subset = mutableListOf<Int>()

        nums.sort()

        fun dfs(start: Int) {
            result.add(ArrayList(subset))

            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue
                }

                subset.add(nums[i])
                dfs(i + 1)
                subset.removeAt(subset.size - 1)
            }
        }

        dfs(0)
        return result
    }
}
