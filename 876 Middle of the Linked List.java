/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) slow = slow.next;
        return slow;
    }
}
/* Fatest solution from AhmedElGamal
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
*/