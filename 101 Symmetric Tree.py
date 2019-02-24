# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: 'TreeNode') -> 'bool':
        if not root: 
            return True
        return self.isSym(root.left, root.right)
    def isSym(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        return self.isSym(left.left, right.right) and self.isSym(left.right, right.left)