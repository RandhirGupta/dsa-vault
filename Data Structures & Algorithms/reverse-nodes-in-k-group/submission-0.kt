/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        val dummy = ListNode(0)
        dummy.next = head

        var groupPrev: ListNode? = dummy

        while (true) {

            // Find kth node
            var kth = groupPrev

            for (i in 0 until k) {

                kth = kth?.next

                if (kth == null) {
                    return dummy.next
                }
            }

            val groupNext = kth?.next

            // Reverse group
            var prev: ListNode? = groupNext
            var curr = groupPrev?.next

            while (curr != groupNext) {

                val temp = curr?.next

                curr?.next = prev

                prev = curr
                curr = temp
            }

            // Reconnect reversed group
            val temp = groupPrev?.next

            groupPrev?.next = kth

            groupPrev = temp
        }
    }
}