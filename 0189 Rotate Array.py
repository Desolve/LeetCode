class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        def numReverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        k, n = k % len(nums), len(nums)
        if k:
            numReverse(0, n - 1)
            numReverse(0, k - 1)
            numReverse(k, n - 1)
'''
# Not in-place solution
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        k %= l
        if k > 0:
            nums[0:l] = nums[-k:] + nums[:-k]
'''