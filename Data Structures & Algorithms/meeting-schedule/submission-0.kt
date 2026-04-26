/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        if (intervals.isEmpty()) return true

        val sorted = intervals.sortedBy { it.start }

        for (i in 1 until sorted.size) {
            val prev = sorted[i - 1]
            var current = sorted[i]

            if (current.start < prev.end) {
                return false
            }
        }

        return true     
    }
}
