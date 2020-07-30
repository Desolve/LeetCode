class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        if num < 1: return False
    
        return num & (num-1) == 0 and num & 0xaaaaaaaa == 0