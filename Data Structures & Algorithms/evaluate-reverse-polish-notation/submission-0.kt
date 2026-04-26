class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> stack.push(stack.pop() + stack.pop())
                "-" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push(a - b)
                }
                "*" -> stack.push(stack.pop() * stack.pop())
                "/" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push(a / b)
                }
                else -> stack.push(token.toInt())
            }
        }

        return stack.peek()
    }
}
