class PrefixTree {

    private val root = TrieNode()

    fun insert(word: String) {
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
        var node = root

        for (c in word) {
            val index = c - 'a'

            if (node.children[index] == null) {
                return false
            }

            node = node.children[index]!!
        }

        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node = root

        for (c in prefix) {
            val index = c - 'a'

            if(node.children[index] == null) {
                return false
            }

            node = node.children[index]!!
        }

        return true
    }
}

class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isEnd = false
}
