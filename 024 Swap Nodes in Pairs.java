/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode sec = first.next;
        ListNode prev;
        first.next = sec.next;
        sec.next = first;
        head = sec;
        prev = first;
        first = first.next;
        
        while (first != null) {
            sec = first.next;
            if (sec == null) return head;
            first.next = sec.next;
            sec.next = first;
            prev.next = sec;
            prev = first;
            first = first.next;
        }
        
        return head;
    }
}