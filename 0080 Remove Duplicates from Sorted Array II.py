class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2: return len(nums)
        last = nums[0]
        cnt, j = 1, 1
        for i in range(1, len(nums)):
            if nums[i] != last:
                nums[j], last = nums[i], nums[i]
                cnt = 1
                j += 1
            elif cnt < 2:
                nums[j] = nums[i]
                j += 1
                cnt += 1
        return j

''' Solution from StefanPochmann
def removeDuplicates(self, nums):
    i = 0
    for n in nums:
        if i < 2 or n > nums[i-2]:
            nums[i] = n
            i += 1
    return i
'''