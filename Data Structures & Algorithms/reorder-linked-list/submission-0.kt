/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var prev: ListNode? = null
        var current = slow?.next
        slow?.next = null

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        var l1 = head
        var l2 = prev

        while (l2 != null) {
            val n1 = l1?.next
            val n2 = l2.next

            l1?.next = l2
            l2.next = n1

            l1 = n1
            l2 = n2
        }
    }
}
