class Solution:
    def numberOfSteps (self, num: int) -> int:
        return bin(num).count('1') + len(bin(num)) - 3
'''
# another solution
class Solution:
    def numberOfSteps (self, num: int) -> int:
        res = 0
        while num != 0:
            res += (num & 1) + 1
            num >>= 1
        return res - 1

# from leetcode
class Solution:
    def numberOfSteps (self, num: int) -> int:
        step = 0
        while num != 0:
            if num % 2 == 0:
                num /= 2
            else:
                num -= 1
            step += 1
            
        return step
'''