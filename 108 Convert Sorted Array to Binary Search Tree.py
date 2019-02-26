# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums: return None
        return self.getNode(nums, 0, len(nums) - 1)
    def getNode(self, nums, start, end):
        if start > end: return None
        mid = start + (end - start) // 2
        r = TreeNode(nums[mid])
        r.left = self.getNode(nums, start, mid - 1)
        r.right = self.getNode(nums, mid + 1, end)
        return r
''' Solution in one function
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums:
            return None

        mid = len(nums) // 2

        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])

        return root
'''