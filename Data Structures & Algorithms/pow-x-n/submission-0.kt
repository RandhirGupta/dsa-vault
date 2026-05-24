class Solution {
    fun myPow(x: Double, n: Int): Double {
        val N = n.toLong()

        val result = power(x, Math.abs(N))

        return if (N >= 0) {
            result
        } else {
            1.0 / result
        }
    }

    private fun power(x: Double, n: Long): Double {
        if (n == 0L) return 1.0

        val half = power(x, n / 2)

        return if (n % 2 == 0L) {
            half * half
        } else {
            half * half * x
        }
    }
}
