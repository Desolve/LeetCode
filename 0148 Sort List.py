# Adapted from jeantimex

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next: return head
        
        prev, slow, fast = None, head, head
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        
        # Clear the first half's last node's next to NIL
        prev.next = None
        
        # n1 : head to prev, n2: slow to the last node
        n1 = self.sortList(head)
        n2 = self.sortList(slow)
        
        return self.merge(n1, n2)
    
    def merge(self, n1: ListNode, n2: ListNode) -> ListNode:
        n = ListNode(0)
        ite = n
        
        while n1 and n2:
            if n1.val < n2.val:
                ite.next = n1
                n1 = n1.next
            else:
                ite.next = n2
                n2 = n2.next
            ite = ite.next
            
        if n1: ite.next = n1
        if n2: ite.next = n2
            
        return n.next
    