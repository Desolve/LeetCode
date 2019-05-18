# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Iterative Solution
class Solution:
    def mergeTwoLists(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        dum = cur = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 or l2
        return dum.next
''' Recursive Solution
class Solution:
    def mergeTwoLists(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        if not l1 or not l2:
            return l1 or l2
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
'''

''' Iterative Solution (in-place)
class Solution:
    def mergeTwoLists(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        if not (l1 and l2):
            return l1 or l2
        dum = cur = ListNode(0)
        dum.next = l1
        while l1 and l2:
            if l1.val < l2.val:
                l1 = l1.next
            else:
                nxt = cur.next
                cur.next = l2
                tmp = l2.next
                l2.next = nxt
                l2 = tmp
            cur = cur.next
        cur.next = l1 or l2
        return dum.next
'''