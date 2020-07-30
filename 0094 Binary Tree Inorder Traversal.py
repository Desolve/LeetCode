# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Recursive solution
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.res = []
        def dfs(root):
            if not root: return
            if root.left: dfs(root.left)
            self.res.append(root.val)
            if root.right: dfs(root.right)
        dfs(root)
        return self.res
        



''' Iterative solution
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            res.append(curr.val)
            curr = curr.right
        return res
'''