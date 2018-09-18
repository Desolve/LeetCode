/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* 註: 題目已經提到node必定為valid的狀態，且不會在linked list的尾端，所以可以完全不用考慮null的情形。
       事實上，如果你考慮null的情形的話，反而會變慢(笑)，這真的很廢XD
*/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}