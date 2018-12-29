/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; ++i) p = p.next;
        
        ListNode q = p.next;
        ListNode r = q.next;
        
        for (int i = 0; i < n - m; ++i) {
            q.next = r.next;
            r.next = p.next;
            p.next = r;
            r = q.next;
        }
        return dummy.next;
    }
}

/* Faster solution adapted from atul555 using stack
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        Stack<ListNode> st = new Stack<>();
        ListNode left = null;
        ListNode node = head;
        int i;
        if (m != 1) {
            for (i = 1; i < m - 1; ++i) node = node.next;
            left = node;
            node = node.next; // starting node
        }
        
        for (i = m; i <= n; ++i) {
            st.push(node);
            node = node.next;
        }
        ListNode l1 = st.pop(), l2 = null;
        if (m == 1) head = l1;
        else left.next = l1;
        while (!st.isEmpty()) {
            l2 = st.pop();
            l1.next = l2;
            l1 = l2;
        }
        l1.next = node;
        
        return head;
    }
}
*/