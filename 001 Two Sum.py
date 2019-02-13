class Solution:
    def twoSum(self, nums: 'List[int]', target: 'int') -> 'List[int]':
        numMap = {}
        for i in range(len(nums)):
            if numMap.__contains__(target-nums[i]):
                return [numMap.get(target-nums[i]), i]
            else:
                numMap[nums[i]] = i