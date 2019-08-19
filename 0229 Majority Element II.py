class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n1, n2, cnt1, cnt2 = 0, 1, 0, 0
        for num in nums:
            if num == n1:
                cnt1 += 1
            elif num == n2:
                cnt2 += 1
            elif cnt1 == 0:
                n1 = num
                cnt1 = 1
            elif cnt2 == 0:
                n2 = num
                cnt2 = 1
            else:
                cnt1 -= 1
                cnt2 -= 1
        
        cnt1, cnt2 = 0, 0
        
        for num in nums:
            if num == n1:
                cnt1 += 1
            elif num == n2:
                cnt2 += 1
        
        res, l = [], len(nums)
        if cnt1 > l // 3:
            res.append(n1)
        if cnt2 > l // 3:
            res.append(n2)
            
        return res


# Easier using Counter
'''
from collections import Counter
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        constraint = len(nums) // 3
        count = Counter(nums)
        res = []
        for k, v in count.items():
            if v > constraint:
                res.append(k)
            
        return res
'''
                