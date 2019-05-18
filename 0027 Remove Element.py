class Solution:
    def removeElement(self, nums: 'List[int]', val: 'int') -> 'int':
        i, l = 0, len(nums)
        while i < l:
            if nums[i] == val:
                l -= 1
                nums[i] = nums[l]
            else:
                i += 1
        return l