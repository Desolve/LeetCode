class Solution:
    def maxSubArray(self, nums: 'List[int]') -> 'int':
        l = len(nums)
        if l == 0: return 0
        res = now = nums[0]
        for i in range(1, l):
            if now > 0:
                now += nums[i]
            else:
                now = nums[i]
            
            if now > res:
                res = now
        return res