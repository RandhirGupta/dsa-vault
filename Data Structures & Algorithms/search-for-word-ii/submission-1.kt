class Solution {

    private val root = TrieNode()

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val result = mutableListOf<String>()

        buildTree(words)

        for (r in board.indices) {
            for (c in board[0].indices) {
                dfs(r, c, root, words, result, board)
            }
        }

        return result
    }

    private fun buildTree(words: Array<String>) {
        for (i in words.indices) {
            var node = root

            for (c in words[i]) {
                val index = c - 'a'

                if (node.children[index] == null) {
                    node.children[index] = TrieNode()
                }

                node = node.children[index]!!
            }

            node.wordIndex = i
        }
    }

    private fun dfs(r: Int, c: Int, node: TrieNode, words: Array<String>, result: MutableList<String>, board: Array<CharArray>) {
        if (r !in board.indices || c !in board[0].indices) return

        val ch = board[r][c]
        if (ch == '#') return

        val child = node.children[ch - 'a'] ?: return

        if (child.wordIndex != -1) {
            result.add(words[child.wordIndex])
            child.wordIndex = -1
        }

        board[r][c] = '#'

        dfs(r + 1, c, child, words, result, board)
        dfs(r - 1, c, child, words, result, board)
        dfs(r, c + 1, child, words, result, board)
        dfs(r, c - 1, child, words, result, board)

        board[r][c] = ch
    }
}

class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var wordIndex = -1
}
