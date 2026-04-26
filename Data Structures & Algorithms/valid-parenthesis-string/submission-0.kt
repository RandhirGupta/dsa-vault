class Solution {
    fun checkValidString(s: String): Boolean {
        val leftStack = ArrayDeque<Int>()
        val starStack = ArrayDeque<Int>()

        for (i in s.indices) {
            when (s[i]) {
                '(' -> leftStack.addLast(i)
                '*' -> starStack.addLast(i)
                ')' -> {
                    if (leftStack.isNotEmpty()) {
                        leftStack.removeLast()
                    } else if (starStack.isNotEmpty()) {
                        starStack.removeLast()
                    } else {
                        return false
                    }
                }
            }
        }

        while (leftStack.isNotEmpty() && starStack.isNotEmpty()) {
            val leftIndex = leftStack.removeLast()
            val starIndex = starStack.removeLast()

            if (leftIndex > starIndex) return false
        }

        return leftStack.isEmpty()
    }
}
