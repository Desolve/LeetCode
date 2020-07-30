# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        if not head: return 0
        res = head.val
        while head.next:
            head = head.next
            res = 2 * res + head.val
        return res