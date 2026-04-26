class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull()!!

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (canFinish(piles, h, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun canFinish(piles: IntArray, h: Int, k: Int): Boolean {
        var hours = 0

        for (pile in piles) {
            hours += (pile + k - 1) / k
        }

        return hours <= h
    }
}
