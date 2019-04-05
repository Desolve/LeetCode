class NumArray:
    
    def __init__(self, nums: List[int]):
        tmp = 0
        self.s = [0]
        for i in nums:
            tmp += i
            self.s.append(tmp)
        

    def sumRange(self, i: int, j: int) -> int:
        return self.s[j+1] - self.s[i]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)

''' Faster solution (56 ms)
class NumArray:
    
    def __init__(self, nums):
        self.dp = [0]*(len(nums)+1)
        for i in range(len(nums)):
        	self.dp[i+1] = self.dp[i]+nums[i]

    def sumRange(self, i, j):
        return self.dp[j+1] - self.dp[i]
'''