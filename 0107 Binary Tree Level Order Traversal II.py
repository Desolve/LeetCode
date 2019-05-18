# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def levelOrderBottom(self, root: 'TreeNode') -> 'List[List[int]]':
        if not root: return []        
        q = []
        res = []
        q.append(root)
        while q:
            llist = []
            lsize = len(q)
            for i in range(lsize):
                n = q.pop(0)
                llist.append(n.val)
                if n.left: q.append(n.left)
                if n.right: q.append(n.right)
            res.insert(0, llist)
        return res
''' 
# Recursive Solution
class Solution:
    def levelOrderBottom(self, root: 'TreeNode') -> 'List[List[int]]':
        res = []
        self.dfs(root, 0, res)
        return res
    def dfs(self, root, level, res):
        if root:
            if len(res) < level + 1:
                res.insert(0, [])
            res[-(level+1)].append(root.val)
            self.dfs(root.left, level+1, res)
            self.dfs(root.right, level+1, res)
'''