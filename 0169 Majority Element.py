class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        cnt, last = 1, nums[0]
        for i in range(1, len(nums)):
            if last == nums[i]:
                cnt += 1
            elif cnt > 0:
                cnt -= 1
            else:
                last = nums[i]
        return last

'''
# Faster in time for test cases, but has bad complexity.
return sorted(nums)[len(nums)//2]
'''