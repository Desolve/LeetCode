# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        if not root: return
        
        l, r = root.left, root.right
        self.flatten(root.left)
        self.flatten(root.right)
        root.left, root.right = None, l
        
        while root.right:
            root = root.right
        root.right = r
        
''' Morris Traversal
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def flatten(self, root: TreeNode) -> None:
        while root:
            if not root.left:
                root = root.right
            else:
                tmp = root.right
                root.right = root.left
                root.left = None
                root = root.right
                r = root
                
                while r.right:
                    r = r.right
                    
                r.right = tmp
'''