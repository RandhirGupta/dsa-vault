class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1Count = IntArray(26)
        val windowCount = IntArray(26)

        for (c in s1) {
            s1Count[c - 'a']++
        }

        var l = 0

        for (r in s2.indices) {
            windowCount[s2[r] - 'a']++

            if (r - l + 1 > s1.length) {
                windowCount[s2[l] - 'a']--
                l++
            }

            if (s1Count.contentEquals(windowCount)) {
                return true
            }
        }

        return false
    }
}
