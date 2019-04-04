class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dic = {}
        for i, v in enumerate(nums):
            if v in dic and i - dic[v] <= k:
                return True
            dic[v] = i
        return False
''' Faster solution adapted from Chomolungma
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        if len(nums)<=k:
            return len(nums) > len(set(nums))

        hashSet=set(nums[:k])
        if len(hashSet) < k:
            return True

        for i in range(k, len(nums)):
            if nums[i] in hashSet:
                return True
            else:
                hashSet.add(nums[i])
                hashSet.remove(nums[i-k])
        return False
'''