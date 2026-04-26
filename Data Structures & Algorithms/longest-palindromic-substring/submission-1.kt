class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        var res = 0
        var resLen = 0

        for (i in s.indices) {
            var left = i
            var right = i

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                val len = right - left + 1
                if (len > resLen) {
                    resLen = len
                    res = left
                }
                left--
                right++
            }

            left = i
            right = i + 1
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                val len = right - left + 1
                if (len > resLen) {
                    resLen = len
                    res = left
                }
                left--
                right++
            }
        }

        return s.substring(res, res + resLen)
    }
}
