# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        d1, d2 = ListNode(0), ListNode(0)
        ite = [d1, d2]
        while head:
            nxt = head.next
            i = 0 if head.val < x else 1
            ite[i].next = head
            ite[i] = ite[i].next
            ite[i].next = None;
            head = nxt
        if not d1.next: return d2.next
        if not d2.next: return d1.next
        ite[0].next = d2.next
        return d1.next