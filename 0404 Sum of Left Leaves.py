# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 使用1/-1來分別代表該節點是左節點/右節點
class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if not root: return 0 # 起始條件檢查
            
        def getSum(n: TreeNode, add: int) -> int:
            if not n: return 0 # NIL, 停止搜索
            if add == 1 and not n.left and not n.right: # n下面沒有別的節點，且當前節點為左節點，將值加上
                return n.val
            return getSum(n.left, 1) + getSum(n.right, -1) # 遞迴尋找所有符合條件的節點，取得值加總即為答案
        
        return getSum(root.left, 1) + getSum(root.right, -1) # 呼叫getSum的遞迴函式開始搜尋
