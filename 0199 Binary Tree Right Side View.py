# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        if not root: return res
        
        q = deque([root])
        while q:
            cnt = len(q)
            for _ in range(cnt):
                last = q.popleft()
                if last.left: q.append(last.left)
                if last.right: q.append(last.right)
            res.append(last.val)
        
        return res