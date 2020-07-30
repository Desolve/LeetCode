/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode ite1 = d1;
        ListNode ite2 = d2;
        while (head != null) {
            ListNode nxt = head.next;
            if (head.val < x) {
                ite1.next = head;
                ite1 = ite1.next;
                ite1.next = null;
            } else {
                ite2.next = head;
                ite2 = ite2.next;
                ite2.next = null;
            }
            head = nxt;
        }
        if (d1.next == null) 
            return d2.next;
        if (d2.next == null)
            return d1.next;
        ite1.next = d2.next;
        return d1.next;
    }
}

/* Simplify
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode[] ite = {d1, d2};
        while (head != null) {
            ListNode nxt = head.next;
            int i = head.val < x ? 0 : 1;
            ite[i].next = head;
            ite[i] = ite[i].next;
            ite[i].next = null;
            head = nxt;
        }
        if (d1.next == null) return d2.next;
        if (d2.next == null) return d1.next;
        ite[0].next = d2.next;
        return d1.next;
    }
}
*/