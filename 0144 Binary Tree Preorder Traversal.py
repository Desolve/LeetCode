# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.preorder(root, res)
        return res
        
    def preorder(self, root: TreeNode, res: List[int]):
        if not root: return
        res.append(root.val)
        self.preorder(root.left, res)
        self.preorder(root.right, res)

'''
# root -> left -> right => In stack: push right->left->root (LIFO)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        if root:
            stack.append(root)
            while stack:
                n = stack.pop()
                if n.right: stack.append(n.right)
                if n.left: stack.append(n.left)
                res.append(n.val)
        return res

'''