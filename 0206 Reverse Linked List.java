/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ArrayList<ListNode> lst = new ArrayList();
        while(head != null) {
            lst.add(head);
            head = head.next;
        }
        int len = lst.size();
        for(int i = len - 1; i > 0; i--) {
            head = lst.get(i);
            head.next = lst.get(i-1);
        }
        lst.get(0).next = null;
        return lst.get(len-1);
    }
}

/* Recursive solution:
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        
        ListNode root = reverseList(head.next);
        
        head.next.next = head; // 將原先的 A->B的指向反向
        head.next = null;      // 反向後最尾端應該指向null
        return root;
    }
}

 */

/* Iteratively solution:
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode next = head.next;
        head.next = null;
        // 每次將head跟next的指向轉向，並且依次向尾端遞移
        while(next != null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }
}

*/