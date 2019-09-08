# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        level, res, maxSum = 1, 1, root.val;
        q = collections.deque()
        q.append(root)
        
        while q:
            total = 0
            cnt = len(q)
            while cnt > 0:
                n = q.popleft()
                total += n.val
                if n.left: q.append(n.left)
                if n.right: q.append(n.right)
                cnt -= 1
                    
            if total > maxSum:
                maxSum, res = total, level            
            level += 1
        return res
        