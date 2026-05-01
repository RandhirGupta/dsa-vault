class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val current = mutableListOf<String>()

        fun isPalindrome(l: Int, r: Int): Boolean {
            var left = l
            var right = r

            while (left < right) {
                if (s[left] != s[right]) return false

                left++
                right--
            }

            return true
        }

        fun dfs(start: Int) {
            if (start == s.length) {
                result.add(ArrayList(current))
                return
            }

            for (end in start until s.length) {
                if (isPalindrome(start, end)) {
                    current.add(s.substring(start, end + 1))

                    dfs(end + 1)

                    current.removeAt(current.size - 1)
                }
            }
        }

        dfs(0)
        return result
    }
}
