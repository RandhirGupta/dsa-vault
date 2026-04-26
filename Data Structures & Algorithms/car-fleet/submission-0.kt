class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        val cars = Array(n) { i -> Pair(position[i], speed[i]) }
        cars.sortByDescending { it.first }

        val stack = ArrayDeque<Double>()

        for ((pos, spd) in cars) {
            val time = (target - pos).toDouble() / spd

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time)
            }
        }

        return stack.size
    }
}
