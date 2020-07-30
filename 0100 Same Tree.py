# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSameTree(self, p: 'TreeNode', q: 'TreeNode') -> 'bool':
        if not p and not q: return True # 均為NIL => 相同(True)
        if not p or not q: return False # 其一為NIL => 不同(False)
        if p.val != q.val: return False # 均存在但節點val不同 => 不同(False)
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right) # 遞迴檢查左子樹/右子樹
        