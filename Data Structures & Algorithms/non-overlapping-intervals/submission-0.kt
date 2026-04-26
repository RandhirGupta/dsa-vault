class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[0] }

        var removals = 0
        var prevEnd = intervals[0][1]

        for (i in 1 until intervals.size) {
            val current = intervals[i]

            if (current[0] >= prevEnd) {
                prevEnd = current[1]
            } else {
                removals++
                prevEnd = minOf(prevEnd, current[1])
            }
        }

        return removals
    }
}
