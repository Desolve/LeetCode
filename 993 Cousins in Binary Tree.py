# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    x_vars = [0, 0]
    y_vars = [0, 0]
    def helper(self, ite: TreeNode, t: int, var: list, prev: int, depth: int) -> bool:
        if not ite: return False
        if t == ite.val:
            var[0] = depth
            var[1] = prev
            return True
        return self.helper(ite.left, t, var, ite.val, 1+depth) or self.helper(ite.right, t, var, ite.val, 1+depth)

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if x == root.val or y == root.val: return False
        
        self.helper(root, x, self.x_vars, 0, 0)
        self.helper(root, y, self.y_vars, 0, 0)
        
        if self.x_vars[0] == self.y_vars[0] and self.x_vars[1] != self.y_vars[1]:
            return True
        return False

''' 
# Solution using queue
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        firstParent = None
        queue = [root]
        while queue:
            nextQueue = []
            for node in queue:
                for nextNode in (node.left, node.right):
                    if nextNode:
                        if nextNode.val in (x, y):
                            if not firstParent:
                                firstParent = node
                            else:
                                return firstParent != node
                        nextQueue.append(nextNode)
            if firstParent:
                return False
            queue = nextQueue
'''