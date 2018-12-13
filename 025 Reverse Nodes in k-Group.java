/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int cnt = 0;
        while (curr != null && cnt != k) {
            curr = curr.next;
            cnt++;
        }
        if (cnt == k) {
            curr = reverseKGroup(curr, k);
            while (cnt-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }        
        return head;
    }
}