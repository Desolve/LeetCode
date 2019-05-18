# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        iteA, iteB = headA, headB
        lenA, lenB = 0, 0
        while iteA is not None:
            lenA += 1
            iteA = iteA.next
        while iteB is not None:
            lenB += 1
            iteB = iteB.next
        diff = lenA - lenB
        iteA, iteB = headA, headB
        if diff > 0:
            for _ in range(diff):
                iteA = iteA.next
        else:
            for _ in range(-diff):
                iteB = iteB.next
        while iteA and iteB:
            if iteA == iteB:
                return iteA
            iteA, iteB = iteA.next, iteB.next
        return None

''' Solution from icrtiou
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB: return None
        iteA, iteB = headA, headB
        
        while iteA != iteB:
            iteA = headB if not iteA else iteA.next
            iteB = headA if not iteB else iteB.next
        
        return iteA
'''