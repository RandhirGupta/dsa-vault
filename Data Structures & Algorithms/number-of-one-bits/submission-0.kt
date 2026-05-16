class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0

        for (i in 0 until 32) {
            val mask = 1 shl i

            if ((n and mask) != 0) {
                count++
            }
        }

        return count
    }
}
