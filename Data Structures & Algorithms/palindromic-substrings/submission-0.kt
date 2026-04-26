class Solution {
    fun countSubstrings(s: String): Int {
        var res = 0

        for (i in s.indices) {
            var left = i
            var right = i

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                res++
                left--
                right++
            }

            left = i
            right = i + 1
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                res++
                left--
                right++
            }
        }

        return res
    }
}
