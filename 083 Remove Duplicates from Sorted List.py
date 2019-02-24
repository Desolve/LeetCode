# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: 'ListNode') -> 'ListNode':
        ite = head
        while ite:
            tmp = ite.next
            while tmp and ite.val == tmp.val:
                tmp = tmp.next
            ite.next = tmp
            ite = tmp        
        return head