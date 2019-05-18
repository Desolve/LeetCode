/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode ite = head;
        while (ite.next != null) {            
            if(ite.next.val == val) ite.next = ite.next.next;
            else ite = ite.next;
        }
        if (head.val == val) return head.next;
        else return head;
    }
}