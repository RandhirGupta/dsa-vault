class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        candidates.sort()
        
        fun dfs(start: Int, remaining: Int) {
            if (remaining == 0) {
                result.add(ArrayList(current))
                return
            }

            if (remaining < 0) {
                return
            }

            for (i in start until candidates.size) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue
                }

                current.add(candidates[i])

                dfs(i + 1, remaining - candidates[i])

                current.removeAt(current.size - 1)
            }
        }

        dfs(0, target)
        return result
    }
}
