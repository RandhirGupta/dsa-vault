class LRUCache(private val capacity: Int) {

    private class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1

        remove(node)
        insertToTail(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            remove(node)
            insertToTail(node)
        } else {
            if (map.size == capacity) {
                val lru = head.next!!
                remove(lru)
                map.remove(lru.key)
            }

            val newNode = Node(key, value)
            map[key] = newNode
            insertToTail(newNode)
        }
    }

    private fun remove(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun insertToTail(node: Node) {
        node.prev = tail.prev
        node.next = tail
        tail.prev?.next = node
        tail.prev = node
    }
}
