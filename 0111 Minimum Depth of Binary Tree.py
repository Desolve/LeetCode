# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root: return 0
        l = self.minDepth(root.left)
        r = self.minDepth(root.right)
        
        return l+r+1 if l == 0 or r == 0 else min(l, r) + 1

''' Faster solution from beglobetrotter
from collections import deque
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root: return 0
        queue, level = deque([(root, 1)]), 0
        while queue:
            node, level = queue.popleft()
            if not node.left and not node.right:
                return level
            if node.left:
                queue.append((node.left, level + 1))
            if node.right:
                queue.append((node.right, level + 1))
'''