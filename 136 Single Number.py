class Solution:
    def singleNumber(self, nums):
        res = nums[0]
        for i in range(1, len(nums)):
            res ^= nums[i]
        return res


'''
class Solution:
    def singleNumber(self, nums):
        res = 0
        for i in nums:
            res ^= i
        return res
'''
''' One line but slower
class Solution:
    def singleNumber(self, nums):
    	return reduce(lambda x, y: x ^ y, nums)
'''