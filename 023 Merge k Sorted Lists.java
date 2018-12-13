/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode ite;
        ListNode head = getMin(lists);
        dummy.next = head;
        while ((ite = getMin(lists)) != null) {
            head.next = ite;
            head = head.next;
        }
        return dummy.next;
    }
    public ListNode getMin(ListNode[] lists) {
        ListNode min = null;
        int index = -1;
        for (int i = 0; i < lists.length; ++i) {
            if (min == null && lists[i] != null) {
                min = lists[i];
                index = i;
            }
            else if (min != null && lists[i] != null) {
                if (min.val > lists[i].val) {
                    min = lists[i];
                    index = i;
                }
            }
        }
        if (index != -1) {
            lists[index] = lists[index].next;
        }
        return min;
    }
}

/* Much faster solution from GraceMeng using divide and conquer(that is merge sort actually).
// see https://leetcode.com/problems/merge-k-sorted-lists/discuss/152022/Beats-99.99-Java-Divide-and-Conquer-with-Explanations
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {        
        return divide(lists, 0, lists.length - 1);
    }
    
    private ListNode divide(ListNode[] lists, int start, int end) {       
        
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return mergeSort(lists[start], lists[end]);
        }

        int mid = start + ((end - start) >> 1);
        ListNode upper = divide(lists, start, mid - 1);
        ListNode lower = divide(lists, mid, end);
                
        return mergeSort(upper, lower);
    }
    
    private ListNode mergeSort(ListNode first, ListNode second) {
        
        ListNode dummyHead = new ListNode(0), ptrFirst = first, ptrSecond = second, ptrDummy = dummyHead;

        while (ptrFirst != null && ptrSecond != null) {
            if (ptrFirst.val < ptrSecond.val) {
                ptrDummy.next = ptrFirst;
                ptrFirst = ptrFirst.next;
                ptrDummy = ptrDummy.next;
            }
            else {
                ptrDummy.next = ptrSecond;
                ptrSecond = ptrSecond.next;
                ptrDummy = ptrDummy.next;                
            }
        }
        
        if (ptrFirst != null) {
            ptrDummy.next = ptrFirst;
        }
        else if (ptrSecond != null) {
            ptrDummy.next = ptrSecond;
        }
        
        return dummyHead.next;
    }
}
*/