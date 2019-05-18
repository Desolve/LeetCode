class Solution(object):
    def hammingWeight(self, n):
        res = 0
        while n > 0:
            res += n & 1
            n >>= 1
        return res
'''
class Solution(object):
    def hammingWeight(self, n):
        res = 0
        while n:
            n &= n-1
            res += 1
        return res
'''
'''
# Or use bin and count functions
class Solution(object):
    def hammingWeight(self, n):
        return bin(n).count('1')
'''