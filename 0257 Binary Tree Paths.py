# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []
        if not root: return res        
        self.getPath(root, "", res)
        return res
        
    def getPath(self, root: TreeNode, s: str, res: List[str]) -> None:
        if not root.left and not root.right:
            res.append(s + str(root.val))
        else:
            tmp = s + str(root.val) + "->"
            if root.left: self.getPath(root.left, tmp, res)
            if root.right: self.getPath(root.right, tmp, res)
            # Or: s += str(root.val) + "->", and replace tmp with s