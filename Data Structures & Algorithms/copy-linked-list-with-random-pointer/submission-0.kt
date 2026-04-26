/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null

        val map = HashMap<Node, Node>()

        var curr = head
        while (curr != null) {
            map[curr] = Node(curr.`val`)
            curr = curr.next
        }

        curr = head
        while (curr != null) {
            val copy = map[curr]!!
            copy.next = map[curr.next]
            copy.random = map[curr.random]
            curr = curr.next
        }

        return map[head]
    }
}
