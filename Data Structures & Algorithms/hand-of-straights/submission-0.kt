class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        hand.sort()
        val freq = HashMap<Int, Int>()
        for (hd in hand) {
            freq[hd] = freq.getOrDefault(hd, 0) + 1
        }

        for (hd in hand) {
            if (freq[hd] == 0) continue

            for (i in 0 until groupSize) {
                val current = hd + i
                if (freq.getOrDefault(current, 0) == 0) {
                    return false
                }

                freq[current] = freq[current]!! - 1
            }
        }

        return true
    }
}
