/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {        
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Now slow is the previous node of the Nth node nrom end of list
        slow.next = slow.next.next;
        return head;
    }
}