# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res = True
    def isBalanced(self, root: TreeNode) -> bool:
        self.maxdp(root)
        return self.res
    def maxdp(self, root):
        if not root or not self.res: return 0
        l = self.maxdp(root.left)
        r = self.maxdp(root.right)
        
        if abs(l-r) > 1:
            self.res = False
            return 0
        return max(l, r) + 1

''' Solution From agave
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def check(root):
            if root is None:
                return 0
            left  = check(root.left)
            right = check(root.right)
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return 1 + max(left, right)
            
        return check(root) != -1
'''

''' From yuzhoujr, using -1 as not balanced
class Solution(object):
    def isBalanced(self, root):
        height = self.get_height(root)
        return height != -1

        
    def get_height(self, root):
        if not root: return 0
        left = self.get_height(root.left)
        right = self.get_height(root.right)
        if left == -1 or right == -1 : return -1          
        if abs(left - right) > 1:  return -1
        return max(left, right) + 1
'''