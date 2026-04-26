class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val patternMap = HashMap<String, MutableList<String>>()
        val wordLen = beginWord.length

        for (word in wordList) {
            for (i in 0 until wordLen) {
                val pattern = word.substring(0, i) + "*" + word.substring(i + 1)

                patternMap
                    .computeIfAbsent(pattern) { mutableListOf() }
                    .add(word)
            }
        }

        val queue = ArrayDeque<Pair<String, Int>>()
        val visited = HashSet<String>()

        queue.add(beginWord to 1)
        visited.add(beginWord)

        while (queue.isNotEmpty()) {
            val (word, steps) = queue.removeFirst()

            if (word == endWord) {
                return steps
            }

            for (i in 0 until wordLen) {
                val pattern = word.substring(0, i) + "*" + word.substring(i + 1)
                val neighbors = patternMap[pattern] ?: continue

                for (neighbor in neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor)
                        queue.add(neighbor to steps + 1)
                    }
                }
            }
        }

        return 0
    }
}
