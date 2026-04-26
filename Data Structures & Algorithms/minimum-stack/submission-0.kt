class MinStack() {

    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)

        if (minStack.isEmpty()) {
            minStack.push(`val`)
        } else {
            minStack.push(minOf(`val`, minStack.peek()))
        }
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
