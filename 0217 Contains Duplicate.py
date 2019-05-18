class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = set()
        for i in nums:
            if i in s:
                return True
            s.add(i)
        return False
''' One line solution(Faster) from caimaoy
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))
'''