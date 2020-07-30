# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.last = None
    def isValidBST(self, root: TreeNode) -> bool:
        if not root: return True
        if not self.isValidBST(root.left): return False
        if self.last and root.val <= self.last.val: return False
        self.last = root
        return self.isValidBST(root.right)
''' Iterative solution
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root: return True
        pre, curr, stack = None, root, []
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            if pre and curr.val <= pre.val:
                return False
            pre = curr
            curr = curr.right
        return True
'''