# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if not preorder: return None
        return self.build(preorder, 0, len(preorder) - 1)

    def build(self, preorder: List[int], l, r) -> TreeNode:
        if l > r: return None
        root = TreeNode(preorder[l])
        i = l + 1
        while i <= r and preorder[i] < preorder[l]:
            i += 1
        root.left = self.build(preorder, l + 1, i - 1)
        root.right = self.build(preorder, i, r)
        return root

''' O(N) Solution from lee215
class Solution:
    i = 0
    def bstFromPreorder(self, A, bound=float('inf')):
        if self.i == len(A) or A[self.i] > bound:
            return None
        root = TreeNode(A[self.i])
        self.i += 1
        root.left = self.bstFromPreorder(A, root.val)
        root.right = self.bstFromPreorder(A, bound)
        return root
'''