class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        if l == 0: return 0
        if l == 1: return nums[0]
        
        # rob house 0 -> can't rob house l-1 -> result = dp[l-2]
        prev, curr = nums[0], nums[0]
        for i in range(2, l-1):
            tmp = prev
            prev = curr
            curr = max(prev, tmp + nums[i])
        res = curr
        
        # don't rob house 0 -> result = dp[l-1]
        prev, curr = 0, nums[1]
        for i in range(2, l):
            tmp = prev
            prev = curr
            curr = max(prev, tmp + nums[i])
        res = max(res, curr)
        
        return res


''' Pack up for-loop as getResult function
class Solution:    
    def getResult(self, nums: List[int], prev: int, curr: int, end: int) -> int:
        for i in range(2, end):
            tmp = prev
            prev = curr
            curr = max(prev, tmp + nums[i])
        return curr

    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        if l == 0: return 0
        if l == 1: return nums[0]
        
        # rob house 0 -> can't rob house l-1 -> result = dp[l-2]
        res = self.getResult(nums, nums[0], nums[0], l-1)        
        # don't rob house 0 -> result = dp[l-1]
        res = max(res, self.getResult(nums, 0, nums[1], l))
        
        return res
'''