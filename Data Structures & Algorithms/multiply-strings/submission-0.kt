class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val m = num1.length
        val n = num2.length

        val result = IntArray(m + n)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val digit1 = num1[i] - '0'
                val digit2 = num2[j] - '0'

                val product = digit1 * digit2

                val p1 = i + j
                val p2 = i + j + 1

                val sum = product + result[p2]
                result[p2] = sum % 10
                result[p1] += sum / 10
            }
        }

        val stringBuilder = StringBuilder()

        for (num in result) {
            if (stringBuilder.isEmpty() && num == 0) {
                continue
            }

            stringBuilder.append(num)
        }

        return stringBuilder.toString()
    }
}
