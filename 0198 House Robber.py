class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) <= 2:
            return max(nums)
        p2, p1 = nums[0], max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            p2, p1 = p1, max(p2 + nums[i], p1)
        
        return p1
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) <= 2:
            return max(nums)
        
        res = [0] * len(nums)
        res[0], res[1] = nums[0], max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            res[i] = max(res[i-2] + nums[i], res[i-1])            
        
        return res[len(nums) - 1]
'''