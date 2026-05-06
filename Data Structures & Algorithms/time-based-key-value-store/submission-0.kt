class TimeMap() {

    private val map = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { mutableListOf() }
            .add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val values = map[key] ?: return ""

        var l = 0
        var r = values.size - 1
        var ans = ""

        while (l <= r) {
            val mid = l + (r - l) / 2

            if (values[mid].first <= timestamp) {
                ans = values[mid].second
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return ans
    }
}
