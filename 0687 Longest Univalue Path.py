# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.mx = 0
    def longestUnivaluePath(self, root: TreeNode) -> int:
        if not root: return 0
        self.count(root, root.val)
        return self.mx
    def count(self, root: TreeNode, val: int) -> int:
        if not root: return 0
        l, r = self.count(root.left, root.val), self.count(root.right, root.val)
        self.mx = max(self.mx, l + r)
        return 0 if root.val != val else max(l, r) + 1