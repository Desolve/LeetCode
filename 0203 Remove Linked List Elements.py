# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if not head: return head
        dummy = ListNode(0)
        dummy.next = head
        
        pv = dummy
        hd = head
        while hd:
            if hd.val == val:
                hd = hd.next
                pv.next = hd
            else:             
                hd = hd.next   
                pv = pv.next
        
        return dummy.next