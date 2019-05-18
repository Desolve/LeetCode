/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ite = head;
        while(ite != null) {
            ListNode tmp = ite.next;
            while (tmp != null && ite.val == tmp.val) tmp = tmp.next;
            ite.next = tmp;
            ite = tmp;
        }
        return head;
    }
}