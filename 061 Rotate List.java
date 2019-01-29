/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++len;
        }
        if (k % len != 0) {
            int p1 = k % len;
            int p2 = len - p1;
            ListNode nTail = head;
            while (--p2 > 0) nTail = nTail.next;
            ListNode nHead = nTail.next;
            ListNode mid = nHead;
            while (--p1 > 0) mid = mid.next;
            mid.next = head;
            nTail.next = null;
            return nHead;
        }
        return head;
    }
}