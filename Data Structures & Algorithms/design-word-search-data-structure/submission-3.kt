class WordDictionary {

    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root

        for (c in word) {
            val index = c - 'a'

            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }

            node = node.children[index]!!
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }

    private fun dfs(word: String, index: Int, node: TrieNode?): Boolean {
        if (node == null) return false
        
        if (index == word.length) {
            return node.isEnd
        }

        val c = word[index]

        if (c == '.') {
            for (child in node.children) {
                if (dfs(word, index + 1, child)) {
                    return true
                }
            }

            return false
        } else {
            val child = node.children[c - 'a']
            return dfs(word, index + 1, child)
        }
    }
}

class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isEnd = false
}