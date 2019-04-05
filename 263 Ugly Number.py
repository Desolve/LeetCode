class Solution:
    def isUgly(self, num: int) -> bool:
        if num <= 0: return False
        if num == 1: return True
        while not num & 1:
            num >>= 1
        while not num % 5:
            num //= 5
        while not num % 3:
            num //= 3
        return num == 1