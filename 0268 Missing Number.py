class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = 0
        n = len(nums)
        for i in range(n):
            res ^= i ^ nums[i]
        res ^= n
        return res
''' Faster solution using the sum difference
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        return n*(1+n)//2 - sum(nums)
'''