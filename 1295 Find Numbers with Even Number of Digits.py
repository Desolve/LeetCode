class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        cnt = 0
        for num in nums:
            if len(str(num)) % 2 == 0:
                cnt += 1
        return cnt
''' solution using dividing by 10
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        cnt = 0
        for num in nums:
            isEven = True
            while num > 0:
                num //= 10
                isEven = not isEven
            if isEven:
                cnt += 1
        return cnt
'''