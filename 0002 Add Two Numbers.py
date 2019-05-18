# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        t1, t2, dum, carry = l1, l2, ListNode(0), 0
        t = dum
        while t1 and t2:
            num = t1.val + t2.val + carry
            carry, num = num // 10, num % 10
            t.next = ListNode(num)
            t, t1, t2 = t.next, t1.next, t2.next
        
        t3 = t1 if t1 else t2
        while t3:
            num = t3.val + carry
            carry, num = num // 10, num % 10
            t.next = ListNode(num)
            t, t3 = t.next, t3.next
        
        if carry:
            t.next = ListNode(carry)
            
        return dum.next

'''
# Or we can combine with 0 and simplify. (The speeds are the same)
class Solution:
    def addTwoNumbers(self, l1: 'ListNode', l2: 'ListNode') -> 'ListNode':
        p1, p2, dum, rem = l1, l2, ListNode(0), 0
        p = dum
        while p1 or p2:
            cur = (p1.val if p1 else 0) + (p2.val if p2 else 0) + rem
            rem, cur = cur // 10, cur % 10
            p.next = ListNode(cur)
            p, p1, p2 = p.next, p1.next if p1 else p1, p2.next if p2 else p2
        if rem: p.next = ListNode(rem)
        return dum.next
'''