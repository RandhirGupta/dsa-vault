/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var result: ListNode? = null

        for (list in lists) {
            result = mergeTwoLists(result, list)
        }

        return result
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy

        var p1 = l1
        var p2 = l2

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                tail.next = p1
                p1 = p1.next
            } else {
                tail.next = p2
                p2 = p2.next
            }

            tail = tail.next!!
        }

        tail.next = p1 ?: p2
        return dummy.next
    }
}
