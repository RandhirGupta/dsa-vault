class Solution {

    fun minWindow(s: String, t: String): String {

        if (t.length > s.length) return ""

        val target = HashMap<Char, Int>()

        for (c in t) {
            target[c] = target.getOrDefault(c, 0) + 1
        }

        val window = HashMap<Char, Int>()

        var have = 0
        val need = target.size

        var l = 0

        var minLen = Int.MAX_VALUE
        var start = 0

        for (r in s.indices) {

            val c = s[r]

            window[c] = window.getOrDefault(c, 0) + 1

            if (
                target.containsKey(c) &&
                window[c] == target[c]
            ) {
                have++
            }

            while (have == need) {

                val windowLen = r - l + 1

                if (windowLen < minLen) {
                    minLen = windowLen
                    start = l
                }

                val leftChar = s[l]

                window[leftChar] = window[leftChar]!! - 1

                if (
                    target.containsKey(leftChar) &&
                    window[leftChar]!! < target[leftChar]!!
                ) {
                    have--
                }

                l++
            }
        }

        return if (minLen == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(start, start + minLen)
        }
    }
}