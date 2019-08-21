// Adapted from jeantimex
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Clear the first half's last node's next to NIL
        prev.next = null;
        
        // n1 : head to prev, n2: slow to the last node
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);
        
        return merge(n1, n2);       
    }
    
    ListNode merge(ListNode n1, ListNode n2) {
        ListNode n = new ListNode(0), ite = n;
        
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                ite.next = n1;
                n1 = n1.next;
            } else {
                ite.next = n2;
                n2 = n2.next;
            }
            ite = ite.next;
        }
        
        // If one list is left
        if (n1 != null) ite.next = n1;
        if (n2 != null) ite.next = n2;
        
        return n.next;
    }
    
}