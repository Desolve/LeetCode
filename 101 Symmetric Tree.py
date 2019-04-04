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

''' Iterative solution(slower)
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        nodes = [root.left, root.right] if root else []
        while nodes:
            l, r = nodes.pop(), nodes.pop()
            if l == r: continue
            if not l or not r or l.val != r.val: return False
            nodes.extend([l.left, r.right, l.right, r.left])
        return True
'''