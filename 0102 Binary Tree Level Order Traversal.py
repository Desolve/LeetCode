# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Iterative solution (BFS)
from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root: return res
        q = deque([root])
        while q:
            cnt = len(q)
            level = []
            for _ in range(cnt):
                node = q.popleft()
                level.append(node.val)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            res.append(level)
        
        return res
            
''' Recursive solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root: return res
        res.append([])
        def helper(n: TreeNode, res: List[List[int]], level: int):
            if not n: return
            if level > len(res) - 1:
                lvl = []
                lvl.append(n.val)
                res.append(lvl)
            else:
                res[level].append(n.val)
            helper(n.left, res, level + 1)
            helper(n.right, res, level + 1)
        
        helper(root, res, 0)
        return res

'''