/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 0, lenB = 0;
        ListNode iteA = headA, iteB = headB;
        // Calculate length of linked list A and linked list B
        while (iteA != null) {
            iteA = iteA.next;
            lenA++;
        }
        while (iteB != null) {
            iteB = iteB.next;
            lenB++;
        }
        // Let the longer linked list go through the diff nodes first
        int diff = lenA - lenB;
        iteA = headA;
        iteB = headB;
        if (diff > 0) {
            while (diff > 0) {
                iteA = iteA.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                iteB = iteB.next;
                diff++;
            }
        }
        // Go one by one and compare, then we'll get the intersected node. (Or meet null at the end)
        while(iteA != null && iteB != null) {
            if (iteA != iteB) {
                iteA = iteA.next;
                iteB = iteB.next;
            } else {
                return iteA;
            }
        }
        return null;
    }
}