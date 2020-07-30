class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = [0] * 3
        for num in nums: 
            n[num] += 1
        for i in range(n[0]): nums[i] = 0
        for i in range(n[0], n[0] + n[1]): nums[i] = 1
        for i in range(n[0] + n[1], n[0] + n[1] + n[2]): nums[i] = 2

'''
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i, i0, i2 = 0, 0, len(nums) - 1
        while i <= i2:
            if nums[i] == 0:
                nums[i], nums[i0] = nums[i0], nums[i]
                i0 += 1
            elif nums[i] == 2:
                nums[i], nums[i2] = nums[i2], nums[i]
                i -= 1
                i2 -= 1
            i += 1
'''