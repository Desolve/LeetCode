/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansRoot = new ListNode(0);
        int carry = 0;
        ListNode curr = ansRoot;
        while (curr != null) {
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            curr.val += a + b;
            carry = curr.val / 10;  // Using if else is slower than "/"
            curr.val %= 10;         // Using
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 != null || l2 != null || carry > 0) // carry == 1 is slower than carry > 0
                curr.next = new ListNode(carry);
            curr = curr.next;           
        }
        return ansRoot;
    }    
}