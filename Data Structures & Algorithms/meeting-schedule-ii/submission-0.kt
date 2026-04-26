/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) return 0

        val n = intervals.size
        val start = IntArray(n)
        val end = IntArray(n)

        for (i in 0 until n) {
            start[i] = intervals[i].start
            end[i] = intervals[i].end
        }

        start.sort()
        end.sort()

        var s = 0
        var e = 0
        var count = 0
        var maxRooms = 0

        while (s < n) {
            if (start[s] < end[e]) {
                count++
                maxRooms = maxOf(maxRooms, count)
                s++
            } else {
                count--
                e++
            }
        }

        return maxRooms
    }
}
