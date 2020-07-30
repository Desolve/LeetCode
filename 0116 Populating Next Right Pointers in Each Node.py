"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root: return None
        if root.left: root.left.next = root.right
        if root.right and root.next: root.right.next = root.next.left
        self.connect(root.left)
        self.connect(root.right)
        return root

'''
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        level_first = root
        while level_first:
            curr = level_first
            while curr:
                if curr.left: curr.left.next = curr.right
                if curr.right and curr.next: curr.right.next = curr.next.left
                curr = curr.next
            level_first = level_first.left
        return root
'''