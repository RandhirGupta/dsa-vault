class Solution {
    fun isHappy(n: Int): Boolean {
        var num = n
        val seen = HashSet<Int>()

        while (num != 1) {
            if (seen.contains(num)) {
                return false
            }

            seen.add(num)
            num = digitSquareSum(num)
        }

        return true
    }

    private fun digitSquareSum(n: Int): Int {
        var num = n
        var sum = 0

        while (num > 0) {
            val digit = num % 10
            sum += digit * digit
            num /= 10
        }

        return sum
    }
}
