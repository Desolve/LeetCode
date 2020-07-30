/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int res = head.val;
        while (head.next != null) {
            head = head.next;
            res = 2 * res + head.val;
        }
        return res;
    }
}