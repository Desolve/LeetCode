# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    sum = 0
    def sumRootToLeaf(self, root: TreeNode) -> int:
        if not root.left and not root.right:
            return root.val
        if root.left: self.helper(root.left, root.val * 2)
        if root.right: self.helper(root.right, root.val * 2)
        return self.sum
    
    def helper(self, r, val):
        tmp = val + r.val
        if not r.left and not r.right:
            self.sum += tmp
        else:
            if r.left: self.helper(r.left, tmp * 2)
            if r.right: self.helper(r.right, tmp * 2)
''' Solution with no global value
def sumRootToLeaf(self, root, val=0):
    if not root: return 0
    val = val * 2 + root.val
    if root.left == root.right: return val # This means that both left and right are null
    return self.sumRootToLeaf(root.left, val) + self.sumRootToLeaf(root.right, val)

'''